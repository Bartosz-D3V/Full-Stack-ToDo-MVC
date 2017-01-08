define([
    "backbone",
    "underscore",
    "handlebars",
    "jquery",
    "toDo",
    "toDoCollection",
    "toDoSingleView"
], function (Backbone, _, Handlebars, $, ToDo, ToDoCollection, ToDoSingleView) {
    var MainView = Backbone.View.extend({
        collection: ToDoCollection,
        el: "body",
        events: {
            "click #addNew": "addNew",
            "keypress": "addNew"
        },

        initialize: function () {
            this.addAll();
        },

        addNew: function (e) {
            if (e.which == 13 || e.type == 'click') {
                var field = $("#taskField"),
                    title = field.val(),
                    toDo = new ToDo({title: title, complete: false}),
                    toDoSingleView = new ToDoSingleView({model: toDo});
                if (title.trim()) {
                    field.val("");
                    this.collection.postNewTask(toDo);
                    $("#listOfToDos").append(toDoSingleView.render().el);
                }
            }
        },

        addAll: function () {
            this.collection.each(function (toDo) {
                this.addExistingToDo(toDo);
            }, this);
        },

        addExistingToDo: function (toDo) {
            var toDoSingleView = new ToDoSingleView({model: toDo});
            $("#listOfToDos").append(toDoSingleView.render().el);
        }

    });
    return new MainView;
});