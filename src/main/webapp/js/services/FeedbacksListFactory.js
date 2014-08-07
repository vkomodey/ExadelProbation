/**
 * Created by Administrator on 04.08.2014.
 */
studentsServices.factory('feedbacksListFactory',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/stud/:studId/feedbacks/get', {}, {
        getFeedbacksList: {method: 'GET', isArray: true}
    });
} ]);
