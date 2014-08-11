/**
 * Created by Administrator on 04.08.2014.
 */
var FeedbacksCtrl = studentsControllers.controller('FeedbacksCtrl', [
    '$scope', '$routeParams', 'feedbacksListFactory', '$q', 'studentsListFactory', '$interval', 'student', '$http',
    function ($scope, $routeParams, feedbacksListFactory, $q, studentsListFactory, $interval, student, $http) {

        $scope.reloadList = function () {
            var deferred = $q.defer();
            feedbacksListFactory.getFeedbacksList({studId: $routeParams.studId}, function (data) {
                $scope.feedbacks = data;
            });

            deferred.resolve($scope.feedbacks);

        };
        // $scope.reloadList();
        /* $interval(function() {
         $scope.reloadList();
         },60000);*/

        $scope.feedbacks = student.feedbacks;
        $scope.studentInfo = student.info;
        if ($scope.feedbacks == null) {
            $scope.cssFeedbacksList = 'feedbacksList-hide';
        }
        if ($scope.studentInfo != null) {
            $scope.exportExcel = function () {
                var arrayToExport = [];
                arrayToExport.push($scope.studentInfo.id);
                StudentListCtrl.export('/rest/downloadExcel', arrayToExport, $http);
            };
            $scope.exportPDF = function () {
                var arrayToExport = [];
                arrayToExport.push($scope.studentInfo.id);
                StudentListCtrl.export('/rest/downloadPDF', arrayToExport, $http);
            };
        }
        // $scope.studentInfo = studentInfo;
        /*var emptyExam = {
         grade: null,
         summer: true,
         course: null
         };*/
        // $scope.exams = $scope.studentInfo.study.exams,
        /*  $scope.examsParams = new ngTableParams({
         page: 1,            // show first page
         count: $scope.studentInfo.study.exams.length,          // count per page
         filter: {
         fio: ''     // initial filter

         },
         sorting: {
         fio: 'asc'     // initial sorting
         }
         }, {
         total: $scope.studentInfo.study.exams.length, // length of data
         getData: function ($defer, params) {
         $scope.reloadList();
         var data = $scope.studentsList;
         $defer.resolve(data.slice());
         }, $scope: { studentsList: {} }
         });
         $scope.addExam = function(){
         $scope.studentInfo.study.exams.push(emptyExam);
         }*/

    }]);
FeedbacksCtrl.feedbacks = function (feedbacksListFactory, $q, $route) {
    var deferred = $q.defer();
    feedbacksListFactory.getFeedbacksList({studId: $route.current.params.studId}, function (data) {
            deferred.resolve(data);
        }
    );
    return deferred.promise;
}