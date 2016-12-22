/**
 * Created by User on 30/06/2016.
 */
requirejs.config({
    baseUrl: 'js',
    paths: {
        main: '../js/app/main/main',
        jquery: '../lib/jquery-2.2.4.min',
        underscore: '../lib/underscore',
        backbone: '../lib/backbone',
        backboneMarionette: '../lib/backbone.marionette',
        handlebars: '../lib/handlebars-v4.0.5',
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