/**
 * Created by User on 30/06/2016.
 */
define([
    "backbone"
], function (Backbone) {
    var globalCounter = 0;
    var ToDo = Backbone.Model.extend({
        id: null,
        default: {
            title: "",
            complete: false
        },

        initialize: function(){
            this.set('id', globalCounter);
            globalCounter += 1;
        },

        getTitle: function () {
            return this.get("title");
        },

        setTitle: function (title) {
            this.set("title", title)
        },

        getComplete: function () {
            return this.get("complete");
        },

        setComplete: function () {
            var complete = !(this.getComplete());
            this.set('complete', complete);
        },

        getId: function () {
            return this.get('id');
        }

    });
    return ToDo;
});
