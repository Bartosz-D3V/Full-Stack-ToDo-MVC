/**
 * Created by User on 07/07/2016.
 * Functions with underscore (_) at the beginning of the function name shall
 * not be called manually.
 */
define([
    'backbone',
    'underscore',
    'handlebars',
    'jquery',
    'toDo',
    'toDoCollection'
], function (Backbone, _, Handlebars, $, ToDo, ToDoCollection) {
    var ToDoSingleView = Backbone.View.extend({
        model: ToDo,
        collection: ToDoCollection,
        tagName: 'div',
        template: Handlebars.compile($('#ToDoTemplate').html()),
        events: {
            'click :checkbox': 'toggleComplete',
            'dblclick #description': 'editTask',
            'click .glyphicon-pencil': 'editTask',
            'click .glyphicon-ok': 'saveTask',
            'keypress #description': 'saveTask',
            "click .glyphicon-remove": "removeTask"
        },

        initialize: function () {
            this.listenTo(this.collection, 'change', this.render);
        },

        render: function () {
            this.$el.fadeIn(300);
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        toggleComplete: function (e) {
            this.model.setComplete();
            this.$('.form-control').toggleClass('done', this.model.getComplete());
            this.model.set('complete', (this.model.getComplete()));
            this.saveTask(e);
        },

        editTask: function (e) {
            this.$('.form-control').attr('readonly', false);
        },

        removeTask: function (e) {
            var self = this;
            this.$el.fadeOut(300, function () {
                self.$el.remove();
                self.collection.remove(self.model);
            })
        },

        saveTask: function (e) {
            if (e.which == 13 || e.type == 'click') {
                var self = this;
                self._makeReadOnly();
                var newTitle = this.$('.form-control').val();
                self.model.setTitle(newTitle);
                self.collection.editTask(self.model);
            }
        },

        _makeReadOnly: function () {
            this.$('.form-control').attr('readonly', true);
        }

    });
    return ToDoSingleView;
});
