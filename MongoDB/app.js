const express = require('express');
const {ObjectId} = require('mongodb');
const {connectToDb, getDb} = require('./db');
const app = express();
const port = 3000;

app.use(express.json());
let db;

connectToDb((err)=>{
    if(!err){
        app.listen(port, ()=>{
            console.log(`Server is running on port ${port}`);     
            })
            db = getDb();
    }
});

// localhost:3000/api/books
app.get('/api/books', (req, res) => {
    let books = [];
    db.collection('Books')
    .find()
    .sort({Rate: -1})
    .foreach(book => books.push(book))
    .then(() => {
        res.status(200).json(books);
    })
    .catch(() => {
        res.status(500).json({error: 'Could not fetch the documents'});
    });
});

// localhost:3000/api/books/add + body
app.post('/api/books/add', (req, res) => {
    const book = req.body;
    db.collection('Books')
    .insertOne(book)
    .then(result => {
        res.status(201).json(result);  
    })
    .catch(err => {
        res.status(500).json({error: 'Could not add the document'});
    });
});

// localhost:3000/api/books/64a7f0c2e1b8c6d5f0a1b2c3
app.delete('/api/books/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id)) {
        return res.status(400).json({ error: 'Invalid book ID' });
    }
    const bookId = req.params.id;
    db.collection('Books')
    .deleteOne({_id: ObjectId(bookId)})
    .then(result => {
        res.status(200).json(result);
    })
    .catch(err => {
        res.status(500).json({error: 'Could not delete the document'});
    });
});

// localhost:3000/api/books/64a7f0c2e1b8c6d5f0a1b2c3 + body
app.put('/api/books/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id)) {
        return res.status(400).json({ error: 'Invalid book ID' });
    }
    
    const bookId = req.params.id;
    const updatedBook = req.body;
    db.collection('Books')
    .updateOne(
        {_id: ObjectId(bookId)},
        {$set: updatedBook}
    )
    .then(result => {
        res.status(200).json(result);
    })
    .catch(err => {
        res.status(500).json({error: 'Could not update the document'});
    });
});

// localhost:3000/api/books/64a7f0c2e1b8c6d5f0a1b2c3/rate
app.patch('/api/books/:id/rate', (req, res) => {
    if (!ObjectId.isValid(req.params.id)) {
        return res.status(400).json({ error: 'Invalid book ID' });
    }
    const bookId = req.params.id;
    const newRate = req.body.Rate;
    db.collection('Books')
    .updateOne(
        {_id: ObjectId(bookId)},   
        {$set: {Rate: newRate}}
    )
    .then(result => {
        res.status(200).json(result);
    })
    .catch(err => {
        res.status(500).json({error: 'Could not update the document'});
    });
});

// localhost:3000/api/books/64a7f0c2e1b8c6d5f0a1b2c3
app.get('/api/books/:id', (req, res) => {
    const bookId = req.params.id;
    db.collection('Books')
    .findOne({_id: ObjectId(bookId)})
    .then(book => {
        res.status(200).json(book);
    })
    .catch(err => {
        res.status(500).json({error: 'Could not fetch the document'});
    });
});

// localhost:3000/api/query?page=2&limit=5
app.get('/api/query', (req, res) => {
    const page = parseInt(req.query.page) || 1;
    const limit = parseInt(req.query.limit) || 10;
    const skip = (page - 1) * limit;

    let books = [];
    db.collection('Books')
    .find()
    .skip(skip)
    .limit(limit)
    .foreach(book => books.push(book))
    .then(() => {
        res.status(200).json(books);
    })
    .catch(() => {
        res.status(500).json({error: 'Could not fetch the documents'});
    });

});