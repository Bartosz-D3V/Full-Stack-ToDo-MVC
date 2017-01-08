requirejs.config({
    baseUrl: 'js',
    paths: {
        main: '../js/app/main/main',
        jquery: '../lib/jquery',
        underscore: '../lib/underscore',
        backbone: '../lib/backbone-min',
        handlebars: '../lib/handlebars',
        toDo: '../js/app/models/toDo',
        toDoCollection: '../js/app/collections/toDoCollection',
        mainView: 'app/views/mainView',
        toDoSingleView: 'app/views/toDoSingleView',
        footerView: 'app/views/footerView'
    }
});

require([
    'backbone',
    'main'
], function (Backbone, Main) {
    new Main();
});