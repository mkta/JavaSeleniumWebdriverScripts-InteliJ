
POST http://ro-dev.rbro.rbg.cc/services/accounts-ws/v1/accounts/balance

{
:   "message":"JSON parse error: Can not deserialize instance of ro.raiffeisen.common.model.accounts.Account[] out of START_OBJECT token; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Can not deserialize instance of ro.raiffeisen.common.model.accounts.Account[] out of START_OBJECT token\n at [Source: java.io.PushbackInputStream@2f961316; line: 1, column: 1]",
:   "errorCode":500,
:   "variables":
:   [
:   ]
}

"=========================================================================================================================================================================================="

POST /accounts-ws/v1/accounts/create 
Body: {"pcId":"20546"}   ---- what is this pcID ?


"=========================================================================================================================================================================================="

GET http://ro-dev.rbro.rbg.cc/services/accounts-ws/v1/eligibilityRestrictions/{paymentActionId}/{accountType}
java.net.URISyntaxException: Illegal character in path at index 75: http://ro-test.rbro.rbg.cc/services/accounts-ws/v1/eligibilityRestrictions/
{
:   paymentActionId
}
/
{
:   accountType
}


GET http://ro-dev.rbro.rbg.cc/services/accounts-ws/v1/eligibilityRestrictions/0110/20


{
:   "timestamp":1505379069128,
:   "status":404,
:   "error":"Not Found",
:   "message":"Not Found",
:   "path":"/v1/eligibilityRestrictions/0110/20"
}

Requires list for this service of:
 - paymentActionId
 - accountType

"=========================================================================================================================================================================================="
"=========================================================================================================================================================================================="
"=========================================================================================================================================================================================="

GET http://ro-test.rbro.rbg.cc/services/cards-ws/v1/credit/periods?accountId=0018059718

{
:   "timestamp":1505382051986,
:   "status":404,
:   "error":"Not Found",
:   "message":"Not Found",
:   "path":"/v1/credit/periods"
}

"=========================================================================================================================================================================================="
"=========================================================================================================================================================================================="

POST http://ro-test.rbro.rbg.cc/services/device-mgmt-service/v1/device/add

post data?


"=========================================================================================================================================================================================="

POST http://ro-test.rbro.rbg.cc/services/directdebit/v1/mandate

post data?

"=========================================================================================================================================================================================="

PUT http://ro-test.rbro.rbg.cc/services/directdebit/v1/mandate

put data?

"=========================================================================================================================================================================================="

GET http://ro-test.rbro.rbg.cc/services/directdebit/v1/mandate?validate-client-identifier?clientId={clientId}&internalId={internalId}&supplierId={supplierId}

clientId={clientId} ?

"=========================================================================================================================================================================================="

POST http://ro-test.rbro.rbg.cc/services/marketing-service/v1/applyForCampaign

{
:   "message":"Required request body is missing: public void ro.raiffeisen.marketing.controller.MarketingApplyController.applyForCreditCard(ro.raiffeisen.core.util.BusinessContext,ro.raiffeisen.marketing.model.ApplyForCampaignRequest,org.springframework.validation.BindingResult) throws java.io.IOException,ro.raiffeisen.core.exception.BadRequestException",
:   "errorCode":500,
:   "variables":
:   [
:   ]
}

post data?

"=========================================================================================================================================================================================="

"=========================================================================================================================================================================================="

GET http://ro-test.rbro.rbg.cc/services/payments-ws/v1/active-payments

{
:   "timestamp":1505397069387,
:   "status":404,
:   "error":"Not Found",
:   "message":"Not Found",
:   "path":"/v1/active-payments"
}

"=========================================================================================================================================================================================="
DELETE http://ro-test.rbro.rbg.cc/services/payments-ws/v1/active-payments


{
:   "timestamp":1505397069437,
:   "status":404,
:   "error":"Not Found",
:   "message":"Not Found",
:   "path":"/v1/active-payments"
}


"=========================================================================================================================================================================================="
POST http://ro-test.rbro.rbg.cc/services/payments-ws/v1/western-union/receive-money

POST data:
{
	"MTCN":"1413412414",
	"account":"0005161502",
	"accountType":"20",
	"expectedAmount":"563.00",
	"expectedCurrency":"RON",
	"originationCountry":"GER",
	"productId":"547"
	}

REsponse:

{
:   "message":"WIE002",
:   "errorCode":400,
:   "variables":
:   [
:   ]
}

"=========================================================================================================================================================================================="
GET http://ro-test.rbro.rbg.cc/services/payments-ws/v1/western-union/taxes-prerequisites
{
:   "timestamp":1505463506811,
:   "status":404,
:   "error":"Not Found",
:   "message":"Not Found",
:   "path":"/v1/western-union/taxes-prerequisites"
}


"=========================================================================================================================================================================================="
GET http://ro-test.rbro.rbg.cc/services/payments-ws/v1/search/taxes-beneficiaries

{
:   "message":"Required String parameter 'type' is not present",
:   "errorCode":500,
:   "variables":
:   [
:   ]
}
"=========================================================================================================================================================================================="
GET http://ro-test.rbro.rbg.cc/services/payments-ws/v1/active-payment/0002052120-2017-09-15-111823-195/instances
{
:   "message":"Required int parameter 'startFrom' is not present",
:   "errorCode":500,
:   "variables":
:   [
:   ]
}


GET http://ro-test.rbro.rbg.cc/services/payments-ws/v1/active-payment/{activePaymentId}/instances

java.net.URISyntaxException: Illegal character in path at index 66: http://ro-test.rbro.rbg.cc/services/payments-ws/v1/active-payment/
{
:   activePaymentId
}

{activePaymentId} ??

"=========================================================================================================================================================================================="
GET http://ro-test.rbro.rbg.cc/services/product-catalog/v2


<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>Error 404 Not Found</title>
</head>
<body><h2>HTTP ERROR 404</h2>
<p>Problem accessing /services/product-catalog/v2. Reason:
<pre>    Not Found</pre></p>
</body>
</html>

"=========================================================================================================================================================================================="
GET http://ro-test.rbro.rbg.cc/product-catalog/v2/cards

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>503 Service Unavailable</title>
</head><body>
<h1>Service Unavailable</h1>
<p>The server is temporarily unable to service your
request due to maintenance downtime or capacity
problems. Please try again later.</p>
</body></html>

"=========================================================================================================================================================================================="
"=========================================================================================================================================================================================="
"=========================================================================================================================================================================================="

POST http://ro-test.rbro.rbg.cc/services/userprofile-ws/v1/user/profile

{
:   "id":-1,
:   "message":"Required request body is missing: public ro.raiffeisen.userprofile.model.UserProfileWsRs ro.raiffeisen.userprofile.controller.UserProfileController.updateUserProfile(ro.raiffeisen.core.util.BusinessContext,ro.raiffeisen.userprofile.model.UserProfileUpdateRq) throws ro.raiffeisen.userprofile.exception.UserProfileWsException"
}

post body ???

"=========================================================================================================================================================================================="

GET http://ro-test.rbro.rbg.cc/portalserver/raiffeisen-portal/index

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>404 Not Found</title>
</head><body>
<h1>Not Found</h1>
<p>The requested URL /portalserver/raiffeisen-portal/index was not found on this server.</p>
</body></html>

"=========================================================================================================================================================================================="

