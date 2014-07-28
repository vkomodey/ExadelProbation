
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div ng-controller="FeedbacksCtrl">
    <div ng-controller="AddFeedbackCtrl">
        <div class="content" ng-init="PopupCssClass = 'popup-hide' ">
            <button ng-click="PopupCssClass = 'popup-show' ">ADD FEEDBACK</button>
            <div ng-class="PopupCssClass"> <!--модальное окно -->
                <h2>Add feedback</h2> <!-- заголовок мо -->
                <fildset>
                    <form class="feedback-popup" name="feedbackForm"> <!-- содержимое модального окна -->
                        <p>Professional suitability
                            <input type="radio" name="profSuitability" value="yes" id="r7" ng-model="profSuitability"
                                   ng-init="profSuitability = true" ng-value="true">
                            <label for="r7"> yes </label><br/>
                            <input type="radio" name="profSuitability" value="no" id="r8" ng-model="profSuitability"
                                   ng-value="false">
                            <label for="r8"> no </label></p>

                        <p>Attitude to work
                            <input type="text" name="attitudeToWork" ng-model="attitudeToWork"></p>

                        <p>Relations in the collective
                            <input type="text" name="relations" ng-model="relations"></p>

                        <p>Progress in professional matters
                            <input type="text" name="progress" ng-model="progress"></p>

                        <p>Is there a need to move the student to work more hours?
                            <input type="radio" name="increaseHours" value="yes" id="r1" ng-model="increaseHours"
                                   ng-init="increaseHours = true" ng-value="true">
                            <label for="r1"> yes </label><br/>
                            <input type="radio" name="increaseHours" value="no" id="r2" ng-model="increaseHours"
                                   ng-value="false">
                            <label for="r2"> no </label></p>


                        <div class="workInProject">
                            <p>Does the student work on a real project?
                                <input type="radio" name="workInProject" value="workInProject" ng-model="workInProject"
                                       ng-init="workInProject = true" ng-value="true"
                                       id="r3">
                                <label for="r3">yes </label><br/>
                                <input type="radio" name="workInProject" value="workInProject" ng-model="workInProject"
                                       ng-value="false"
                                       id="r4">
                                <label for="r4">no</label></p>

                            <div ng-hide="workInProject" class="false">
                                <p>If no, is there prospect of working on a real project?
                                    <input type="radio" name="prospect" value="yes" id="r9" ng-model="prospect"
                                           ng-init="prospect = true" ng-value="true">
                                    <label for="r9"> yes </label><br/>
                                    <input type="radio" name="prospect" value="no" id="r10" ng-model="prospect"
                                           ng-value="false">
                                    <label for="r10"> no </label></p>
                            </div>
                        </div>

                        <p>Something else at your discretion
                            <input type="text" name="other" ng-model="other"></p>
                        <div class="buttons">
                            <button type="submit" ng-click="addFeedback()" ng-disabled="feedbackForm.$invalid">Save</button>

                            <button ng-click="PopupCssClass = 'popup-hide'">Cancel</button>
                        </div>
                    </form>
                </fildset>
            </div>
            <button ng-click="reloadList()">reload</button>
            <input type="text" ng-model="search.feedbacker" placeholder="Search">
            <table ng-table="tableParams" class="table">
                <tr ng-repeat="feedback in feedbacks | filter:search |orderBy:params.orderBy()">
                    <td data-title="'APTITUDE'" sortable="'aptitude'">{{feedback.aptitude}}</td>
                    <td data-title="'ATTITUDE TO WORK'" sortable="'attitudeToWork'">{{feedback.attitudeToWork}}</td>
                    <td data-title="'RELATIONS IN COLLECTIVE'" sortable="'relationsInCollective'">
                        {{feedback.relationsInCollective}}
                    </td>
                    <td data-title="'PROGRESS'" sortable="'progress'">{{feedback.progress}}</td>
                    <td data-title="'INCREASE HOURS'" sortable="'increaseHours'">{{feedback.increaseHours}}</td>
                    <td data-title="'WORK IN PROJECT'" sortable="'workInProject'">{{feedback.workInProject}}</td>
                    <td data-title="'BILLABLE'" sortable="'billable'">{{feedback.billable}}</td>
                    <td data-title="'OTHER'" sortable="'other'">{{feedback.other}}</td>
                    <td data-title="'FEEDBACKER'" sortable="'feedbacker'">{{feedback.feedbacker}}</td>
                    <td data-title="'DATE'" sortable="'date'">{{feedback.date}}</td>
                </tr>
            </table>
        </div>
    </div>
</div>