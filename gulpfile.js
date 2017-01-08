var gulp = require('gulp');

gulp.task('copyLibraries', function () {
    return gulp.src(['node_modules/backbone/backbone-min.js',
        'node_modules/bootstrap/dist/**/*',
        'node_modules/requirejs/require.js',
        'node_modules/handlebars/dist/handlebars.js',
        'node_modules/jquery/dist/jquery.js',
        'node_modules/underscore/underscore.js'])
        .pipe(gulp.dest('webapp/lib'));
});

gulp.task('default', ['copyLibraries']);