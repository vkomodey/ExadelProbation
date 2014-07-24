var myApp = angular.module('myApp', ['ui.bootstrap']);

myApp.factory('Students', function() {
    var Students = {};
    Students.cast = [
        {
            fio: "Albert Lod",
            date: "22.07.2013",
            faculty: "FPMI",
            year: "2017",
            curse: "4/7",
            hours: "30",
            billable: "no",
            role: "junior"+" "+"22.05.2003",
            technologies:"java, javascript",
            level: "Intermediate"

        },
        {
            fio: "Robert Chris Lod",
            date: "22.07.2014",
            faculty: "FPMI",
            year: "2017",
            curse: "2/7",
            hours: "20",
            billable: "no",
            role: "junior"+" "+"22.05.2003",
            technologies:"java, javascript",
            level: "Intermediate"

        },
        {
            fio: "Robert Chris Lod",
            date: "22.07.2013",
            faculty: "FPMI",
            year: "2017",
            curse: "4/6",
            hours: "30",
            billable: "no",
            role: "junior"+" "+"22.05.2003",
            technologies:"java, javascript",
            level: "Intermediate"

        },
        {
            fio: "Robert Chris Lod",
            date: "22.07.2013",
            faculty: "FPMI",
            year: "2017",
            curse: "4/7",
            hours: "30",
            billable: "no",
            role: "junior"+" "+"22.05.2003",
            technologies:"java, javascript",
            level: "Intermediate"

        },
        {
            fio: "Robert Chris Lod",
            date: "22.07.2013",
            faculty: "FPMI",
            year: "2017",
            curse: "4/7",
            hours: "30",
            billable: "no",
            role: "junior"+" "+"22.05.2003",
            technologies:"java, javascript",
            level: "Intermediate"

        }

    ];
    return Students;
})

function StudentsCtrl($scope, Students) {
    $scope.students = Students;
}
 myApp.directive("english", function(){
     return {
         restrict: "E",
         scope: {
             englishlevel: "="
         },
         template: '<div><select ng-model="englishlevel" ng-options="englishlevel for englishlevel in englishlevels"></div>',

         link: function(scope) {
             scope.englishlevels = ["Beginner", "Elementary", "Pre-Intermediate", "Intermediate", "Upper-Intermediate", "Advanced"];
             scope.englishlevel = scope.englishlevels[0]
         }
     }

 } );
myApp.directive("develop", function(){
    return {
        restrict: "E",
        scope: {
            devlevel: "="
        },
        template: '<div><select ng-model="devlevel" ng-options="devlevel for devlevel in devlevels"></div>',

        link: function(scope) {
            scope.devlevels = ["junior", "developer", "tester"];
            scope.devlevel = scope.devlevels[0]
        }
    }

} );
