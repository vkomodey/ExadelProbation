/**
 * Created by Administrator on 14.08.2014.
 */
studentsControllers.controller('EditFeedbackCtrl',['$scope','$http',function($scope,$http){
    $scope.editFeedback = function() {
        $http.post('/rest/feedback/'+$scope.feedbackEdit.id+'/modify',$scope.feedbackEdit)
            .success(function(){
                $scope.reloadList();
            })
            .error(function(data,status){
                alert('ERROR ' + status);
            })
    }
}]);