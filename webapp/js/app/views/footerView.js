define([
    'backbone',
    'underscore',
    'handlebars',
    'toDoCollection'
], function (Backbone, _, Handlebars, ToDoCollection) {
    var FooterView = Backbone.View.extend({
        collection: ToDoCollection,
        tagName: 'div',
        template: Handlebars.compile($('#ToDoFooterTemplate').html()),

        initialize: function () {
            this.listenTo(this.collection, 'change', this.render);
            this.listenTo(this.collection, 'remove', this.render);
            this.listenTo(this.collection, 'add', this.render);
        },

        render: function () {
            this.$el.html(this.template(this._prepareData()));
            return this;
        },

        _prepareData: function () {
            var context = {
                numOfTasks: this.collection.getNumberOfTasks(),
                numOfCompleted: this.collection.getNumberOfCompletedTasks()
            };
            return context;
        }
    });
    return new FooterView;
});