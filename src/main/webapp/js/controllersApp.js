/**
 * Created by Administrator on 18.07.2014.
 */
var studentsControllers = angular.module('studentsControllers',['ngTable']);

studentsControllers.controller('FeedbacksCtrl', ['$scope', '$routeParams','feedbacksList', function($scope,$routeParams,feedbacksList) {

    $scope.feedbacks = feedbacksList.getFeedbacksList({studId: $routeParams.studId});
}]);

studentsControllers.controller('StudentListCtrl',['$scope','$filter','$routeParams','feedbacksList', 'ngTableParams',  function( $scope, $filter,$routeParams, feedbacksList, ngTableParams) {

    var getData = function() {
        return $scope.students = feedbacksList.getStudentsList();
    }
    $scope.students =  feedbacksList.getStudentsList();
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.students.length,          // count per page
            filter: {
                fio: ''     // initial filter

            },
            sorting: {
                fio: 'asc'     // initial sorting
            }
        }, {
            total: $scope.students.length, // length of data
            getData: function(params) {
                // use build-in angular filter
                var filteredData = getData();/*params.filter() ?
                    $filter('filter')($scope.students, params.filter()) :
                    $scope.students;*/
                var orderedData = params.sorting() ?
                    $filter('orderBy')($scope.students, params.orderBy()) :
                    filteredData;

                params.total(orderedData.length); // set total for recalc pagination
                //$defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            },  $scope: { students: {} }
        });
}]);

studentsControllers.controller('CreateStudentCtrl', ['$scope', '$http', 'ngTableParams', function($scope,$http,ngTableParams){
    $scope.createStudent = function() {
        var newStudent = [{
            login: $scope.login
        }];
        $http.post('json/app.json',newStudent).success(function() { $scope.PopupCssClass = 'popup-hide'; $scope.tableParams.reload()});
    };
}]);