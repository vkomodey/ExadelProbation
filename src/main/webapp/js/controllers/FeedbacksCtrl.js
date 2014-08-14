/**
 * Created by Administrator on 04.08.2014.
 */
var FeedbacksCtrl = studentsControllers.controller('FeedbacksCtrl', [
    '$scope', '$routeParams', 'feedbacksListFactory', '$q', 'studentsListFactory', '$interval','ProjectHistoryFactory', 'student', '$http',
    function ($scope, $routeParams, feedbacksListFactory, $q, studentsListFactory, $interval,ProjectHistoryFactory, student, $http) {

        $scope.reloadList = function () {
            var deferred = $q.defer();
            feedbacksListFactory.getFeedbacksList({studId: $routeParams.studId}, function (data) {
                $scope.feedbacks = data;
            });

            deferred.resolve($scope.feedbacks);

        };
        $scope.feedbacks = student.feedbacks;
        $scope.studentInfo = student.info;
        if ($scope.feedbacks == null) {
            $scope.cssFeedbacksList = 'feedbacksList-hide';
        }
        $scope.reloadProjectHistory = function(){
            $scope.projectHistoryList = ProjectHistoryFactory.getProjectHistory({studId: $scope.studentInfo.id});
        };
    }]);
FeedbacksCtrl.feedbacks = function (feedbacksListFactory, $q, $route) {
    var deferred = $q.defer();
    feedbacksListFactory.getFeedbacksList({studId: $route.current.params.studId}, function (data) {
            deferred.resolve(data);
        }
    );
    return deferred.promise;
}