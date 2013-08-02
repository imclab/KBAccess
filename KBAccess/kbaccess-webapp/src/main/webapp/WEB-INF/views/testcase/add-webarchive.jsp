<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="fr">
    <c:set var="title">
	<fmt:message key="testcase.addWaTitle" />
    </c:set>
    <%@include file="/WEB-INF/template/head.jspf" %>

    <body>
        <%@include file='/WEB-INF/template/header.jspf' %>
        
        <c:set var="bcAddExampleStep3" scope="page"><fmt:message key="breadcrumb.addExampleStep3" /></c:set>
        <c:set target="${breadcrumbTrail}" property="KBAccess" value="/"/> 
        <c:set target="${breadcrumbTrail}" property="${bcAddExampleStep3}" value=""/>
        
        <%@include file='/WEB-INF/template/breadcrumb-trail.jspf'%>

        <h1 class="page-header"><fmt:message key="testcase.addWaH1" /></h1>
        <div class="row-fluid">
            <form:form id="new-tc-form" commandName="newTestcaseCommand" action="add-finalize.html" method="POST">
                <c:if test="${generalErrorMessage != null}">
                    <p class="alert alert-error">
                        <fmt:message key="${generalErrorMessage}" />
                    </p>
                </c:if>
                <form:hidden path="idReference"/>
                <form:hidden path="description"/>
                <form:hidden path="idReferenceDepth"/>
                <form:hidden path="idReferenceTest"/>
                <form:hidden path="idResult"/>
                <form:errors path="createWebarchive" cssClass="alert alert-error" element="p"/>
                <%@include file="/WEB-INF/template/block/mandatory-fields.jspf" %>
                <div id="existing-webarchive-group" class="control-group">
                    <form:radiobutton path="createWebarchive" value="false" id="testcase_existing_webarchive"/>
                    <label class="control-label new-tc-label" for="testcase_existing_webarchive"><fmt:message key="testcase.addWaExisting" /></label>
                    <div class="controls">
                        <div class="control-group">
                            <label class="control-label" for="testcase_idwebarchive"><%@include file="/WEB-INF/template/inline/mandatory.jspf"%>Webarchive :</label>
                            <div class="controls new-tc-block">
                                <form:select class="span5" path="idWebarchive" id="testcase_idwebarchive">
                                    <c:forEach var="webarchive" items="${webarchiveList}">
                                        <option value="${webarchive.id}">
                                            ${webarchive.url} : 
                                            <fmt:formatDate dateStyle="short" timeStyle="short" value="${webarchive.creationDate}"/></option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="idWebarchive" cssClass="alert alert-error" element="p"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="create-webarchive-group" class="control-group">
                    <form:radiobutton path="createWebarchive" value="true" id="testcase_create_webarchive"/>
                    <label class="control-label new-tc-label" for="testcase_create_webarchive"><fmt:message key="testcase.addWaCreate" /></label>
                    <div class="controls">
                        <div class="control-group">
                            <label class="control-label" for="webarchive_url"><span class="mandatory" title="Champ obligatoire">*</span>URL :</label>
                            <div class="controls new-tc-block">
                                <form:input class="span5" path="urlNewWebarchive" id="webarchive_url"/>
                                <form:errors path="urlNewWebarchive" cssClass="alert alert-error" element="p"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="new-tc-label" for="webarchive_description"><fmt:message key="description" /> :</label>
                            <div class="controls new-tc-block">
                                <form:textarea class="span5" path="descriptionNewWebarchive" id="webarchive_description" rows="4" cols="35"/>
                                <form:errors path="descriptionNewWebarchive" cssClass="alert alert-error" element="p"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <button class="btn btn-info"><fmt:message key="testcase.addButton" /></button>
                </div>
            </form:form>
        </div>

        <%@ include file='/WEB-INF/template/footer.jspf' %>
    </body>
</html>