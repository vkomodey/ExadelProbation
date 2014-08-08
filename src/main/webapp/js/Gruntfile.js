module.exports = function (grunt) {
    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                stripBanners: true,
                banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - ' +
                    '<%= grunt.template.today("yyyy-mm-dd") %> */\n\n'
            },
            dist: {
                src: [
                    //'js/lib/angular.min.js',
                    //'js/lib/angular-route.js',
                   // 'js/lib/jquery.min.js',
                    //'js/lib/bootstrap.js',
                   // 'js/app.js',
                    //'js/services/*.js',
                    //'js/controllers/*.js'
                    'lib/angular.min.js',
                   'lib/bootstrap.min.js',
                    'lib/bootstrap-modal.js',
                    'lib/bootstrap-tab.js',
                    'lib/*.js',
					'app.js',
					'config/*.js',
					'services/*.js',
					'controllers/*.js'
                ],
                dest: 'built.js',
            },
        },
        watch: {
            scripts: {
                files: ['**/*.js'],
                tasks: ['concat'],
            },
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-ng-annotate');
}
