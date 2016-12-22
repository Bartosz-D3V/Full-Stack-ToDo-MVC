/**
 * Created by User on 30/06/2016.
 */
define([
    'backbone',
    'underscore',
    'mainView',
    'footerView'
], function (Backbone, _, MainView, FooterView) {
    var Main = Backbone.View.extend({
        view: MainView,
        footer: FooterView,

        initialize: function () {
            $('#listOfToDos').append(this.view.template);
            $("#toDosFooter").append(FooterView.render().el);
        }
    });
    return Main;
});
