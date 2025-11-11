const {MongoClient} = require('mongodb');

let dbConnection;

module.exports = {
    connectToDb: (cb) => {
        MongoClient.connect('mongodb://172.18.160.1:27017/Library')
        .then((client) => {
            dbConnection = client.db();
            return cb();
        })
        .catch(err => {
            console.log(err);
            return cb(err);
        });
    },

    getDb: () => dbConnection
}; 