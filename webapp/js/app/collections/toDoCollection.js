define([
    'backbone',
    'jquery',
    'toDo'
], function (Backbone, $, ToDo) {
    var ToDoCollection = Backbone.Collection.extend({
        model: ToDo,
        url: 'http://localhost:8080/todo',

        initialize: function () {
            this.fetch({
                async: false
            });
            this.on('change', this.editTask, this);
            this.on('remove', this.deleteTask, this);
        },

        postNewTask: function (toDo) {
            $.ajax({
                type: 'POST',
                url: "http://localhost:8080/todo/",
                data: toDo.toJSON(),
                dataType: "JSON",
                async: true
            });
            this.add(toDo);
        },

        deleteTask: function (toDo) {
            var index = toDo.getId();
            $.ajax({
                type: 'DELETE',
                url: "http://localhost:8080/todo/" + index,
                async: true
            });
            this.remove(toDo, {silent: true});
        },

        editTask: function (toDo) {
            var index = toDo.getId();
            $.ajax({
                type: 'PUT',
                url: "http://localhost:8080/todo/" + index,
                data: toDo.toJSON(),
                dataType: "JSON",
                async: true
            });
            this.remove(toDo, {silent: true});
            this.add(toDo, {at: toDo.getId()});
        },

        getNumberOfTasks: function () {
            return this.length;
        },

        getNumberOfCompletedTasks: function () {
            var completedToDos = this.where({complete: true});
            return completedToDos.length;
        }

    });
    return new ToDoCollection;
});
