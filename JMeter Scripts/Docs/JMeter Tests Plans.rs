

*************** JMeter Tests plans ***************

*****Contacts*****

[GET]
//	* GET
//		    - assert status
//		    - assert contacts
//	* GET + size param (default 10)
//		    - assert status
//		    - assert contacts
//		    - assert size
//	* GET + query
//		    - assert status
//		    - assert contact query (name)

[POST]
//	* POST no pic + valid data
//		    - assert status
//		    - assert id
//		    - assert name
//		    - assert email
//		    - assert status
//		    - assert error
//	* POST with pic + valid data
//		    - assert status
//		    - assert id
//		    - assert name
//		    - assert email
//		    - assert pic url
//	* POTT with pic + invalid data
//		    - assert status
//		    - assert error
//	* POST with invalid pic format + valid data
//		    - assert status
//		    - assert error
//	* POST with invalid pic + invalid data
//		    - assert status
//		    - assert error
//[GET] - specific id
//	* GET valid id
//		    - assert status
//		    - assert id
//		    - assert name
//	*GET invalid id
//		    - assert status
//		    - assert error
	

[PUT] x2 (with avatar initially uploaded and without)
	* PUT add to favorite
        - assert status
        - assert favorite true
	* PUT remove from favorite
        - assert status
        - assert favorite false
	* PUT valid contact edit + no favorite change
        - assert status
        - assert valid change
	*PUT valid contact edit + favorite change
        - assert status
        - assert valid change
        - assert favorite true
	*PUT invalid change
        - assert status
        - assert error message
	*PUT invalid change + favorite
        - assert status
        - assert error message
	*PUT change asset
        - assert status
        - assert pictureURL

[DELETE]
	*DELETE
        - assert status
	*GET valid id AFTER DELETE
        - assert Error

[POST]  - validate
	*POST
        - assert status
        - assert response


/******FX Rates*****

1. Get FX rates: GET /list
        - verify currency is displayed
        - verify status
        - extract buying is displayed
        - extract selling is displayed
2. Get Conversion rate: GET /{operation}/{currencyFrom}/{currencyTo}
        - verify buy param
        - verify sell param
        - verify fx rate*/


*****CARDS*****

//[GET] /v2/cards
//			   - verify cards are retrieved
//			   - verify 200 status
//			   - extract accID & cardID
			
//[GET] /v2/cards?
//			   - page={page_no}&
//			   - size={page_size}&
//			   - accountId={account_id}&
//			   - cardStatus={All|Active|Cancelled|Blocked}& - default ALL
//			   - clientType={PF|PJ}&
//			   - sourceApplication={IBK}  - default IBK and only supported
//			   - verify status
//			   - verify response according with param
//			   - extract accID & cardID

//[POST] /v1/block-card
//			   - verify status 200
//			   - verify error status

//[POST] /v1/cards/eligible/credit
//			   - verify status
//			   - verify response true/false

//[POST] /v1/cards/apply/debit
//			   - verify status
//			   - verify response

//[GET] /v1/credit/transactions?
//			   - accountId={accountId}&
//			   - startDate={startDate}&
//			   - limit={limit}&
//			   - skip={skip}
//			   - verify status
//			   - verify response

//[GET] /v1/credit/periods?
//			   - accountId={accountId}
//			   - verify response
//			   - verify status


*****DEVICE MANAGMENT*****

public class Device {
    private String deviceId;
    //User CIF, can be change after CIAM
    private String userId;
    private String deviceName;
    private String operatingSystem;
    private Date registerDate;
}

[GET] services/device-mgmt-service/v1/device/list
        - verify status
        - verify list not empty

[POST] services/device-mgmt-service/v1/device/add
        - verify status
        - verify response if available

[PUT] services/device-mgmt-service/v1/device/update/${deviceID}
        - verify status
        - verify response if available

[DELETE] services/device-mgmt-service/v1/device/delete/${deviceID}
        - verify status
        - verify response if available

        - Auto user id extracted at login Tests
        - Manual user id tests
        - multiple devices add tests
        - multiple devices remove tests

*****TRANSACTIONS*****

//GET /v1/transaction-dates?accountId={accountId}&accountType={accountType}
//		    - test for account type 20
//		    - test for account type 26
//		    - test for account type 30
//		    - test for account type 50
//		    - test for account type 99
//		    - verify status 200
//		    - verify not empty

//POST /v1/transactions
//		    - test for account type 20
//		    - test for account type 26
//		    - test for account type 30
//		    - test for account type 50
//		    - test for account type 99
//		    - verify status 200
//		    - verify not empty
//		    - test date format is yyyy-MM-dd
//		    - test "searchText" : "various text",
//		    - test "endDate":
//		    - test "startDate":
//		    - test "filter" : {
					/*"searchInBeneficiaryOnly" : true/false,
					"searchInDescriptionOnly" : true/false,*/
//					"includeDebitTransactions" : true/false,
//					"includeCreditTransactions" : true/false}
//		    - test transactionStatusTypes   - array containing at least one of the following possible values: SUCCESS, PENDING, HOLD, REJECTED

//POST services/transactions-bff/v1/pending-rejected-transaction
//			   - verify status

//DELETE services/transactions-bff/v1/pending-rejected-transaction
//			   - verify status


*****USER PROFILE*****

//GET /v1/user/profile/?refresh={true}
//			   - verify status
//			   - verify response not empty
/*			{
				"user": {
				  "id": "0002052120",
				  "firstName": "VALENTIN",
				  "lastName": "CONDREA",
				  "cnp": "1840404393612",
				  "phoneNumbers": [
				      "004 021 306 30 02",
				      "0800 802 02 02"
				  ]
				},
				"accountsListOrder": [
				  5161502
				],
				"accountsNicknames": {
				  "5161502": "Cont Salariu",
				  "11185325": "Cumparaturi",
				  "11532971": "Cont Economii"
				}
				}
*///			 - verify with and without param refresh ( refresh: Retrieves data directly ignoring cache. Should only be used for login )

//POST /v1/user/profile
//{
//"accountListOrder": [15628836, 12175368]
//}

//		    - verify status 200
//		    - verify response message ok

//GET /v1/user/profile/branch
//			   - verify status 200
//			   - verify response branch id

//POST /v1/user/avatar
//multipart param picture
//
//			   - verify status 200
//			   - verify reponse avatar url

*****USER PROFILE*****

//1. Create account: POST
//
///v1/accounts/create

//{
  //"pcId": "30128",
  //"interestAccount": "0011185325",
  //"principalAccount": "0011185325",
  //"amount": "200",
  //"fromAccount": "0011185325"
//}
//
  //      - verify status 200
    //    - verify iban generated
      //  - verify all pcId type
        //- extract iban

//2. Account Balance:

//POST /v1/accounts/balance

//[
//  { "id": "123", "typeId": "20" },
//  { "id": "1234", "typeId": "26" }
//]

//        - verify status 200
 //       - verify balance returned for each account type

//3. Eligible TM accounts:

//GET /v1/accounts/eligible/tm?currency={currency}

//        - verify status 200
  //      - verify response if available


/*4. Account holds:

GET /v1/accounts/listHolds?accountId={accountId}&allowedTypes[]={type1}&allowedTypes[]={type2}

        - verify status 200
        - verify response if available
        - verify with and without params*/

/*5. Account Customer details:

GET /v1/accounts/customer-details/{accountNr}

        - verify status 200
        - verify response contains cif, id, accoun, first name, last name, currency*/

/*6. Get Accounts eligible for Debit Cards:

GET /v1/accounts/eligible/debit

        - verify status 200
        - verfiy response if available*/

/*7. Get payments accounts eligibility:

POST /v1/accounts/eligible/payment

{
    "accountTypeProductIds": [
        {
            "typeId": "20",
            "prodId": "80"
        },
        {
            "typeId": "20",
            "prodId": "90"
        }
    ]
}

        - verify status 200
        - verify response db and cr eligibilitty*/

/*8. Eligible top up accounts:

GET /v1/accounts/eligible/recharge

        - verify status 200
        - verift response if available*/

/*9. Get eligibility restrictions list
GET /eligibilityRestrictions/{paymentActionId}/{accountType}

        - verify status 200
        - verify response
*/

*****PAYMENTS*****

//1. Active payments: GET /active-payment/list
//
  //      - verify status 200
    //    - verify list not empty

/* 2. Post payment: POST /post-payment

        - test Transfer intre contur proprii - 0003
                {
                    "actionId": "0003",
                    "amount": 1.00,
                    "details": ["TRANSFER INTRE CONTURI"],
                    "currency": "RON",
                    "basic": {
                      "paymentDate": "2017-08-14"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "RO40RZBR0000060011185325"
                    }
                }
        - test Schimb valutar - 0110
                {
                    "actionId": "0110",
                    "amount": 1.00,
                    "details": ["SCH VALUTAR"],
                    "currency": "EUR",
                    "basic": {
                      "paymentDate": "2017-08-16"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "RO36RZBR0000060012142690"
                    }
                }
        - test Intrabancara - 0009
                {
                    "actionId": "0009",
                    "amount": 1.00,
                    "details": ["INTRABANK"],
                    "currency": "RON",
                    "basic": {
                      "paymentDate": "2017-08-16"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "RO89RZBR0000060018034486"
                    }
                }
        - test Interbancara RON - 0111
                {
                    "actionId": "0111",
                    "amount": 5,
                    "details": ["INTERBANK ING"],
                    "currency": "RON",
                    "basic": {
                      "paymentDate": "2017-08-16"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "RO50INGB0001008189548910"
                    },
                    "payee": {
                      "fullName": "gigi"
                    }
                }
        - test Interbancara valuta - 0137
                {
                    "actionId": "0137",
                    "amount": 1.00,
                    "details": ["FCY INTERBANK"],
                    "currency": "EUR",
                    "basic": {
                      "paymentDate": "2017-08-16",
                      "priority": "STANDARD",
                      "feeType": "SHA"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "HU99588899993456678912346789"
                    },
                    "payee": {
                      "fullName": "gigi"
                    },
                    "payeeAdditionalInfo": {
                        "name": "gigi",
                        "address": "adresa"
                    }
                }
        - test Taxe - 0300
                {
                    "actionId": "0300",
                    "amount": 1.00,
                    "details": ["TAX PAYMENT"],
                    "currency": "RON",
                    "basic": {
                      "paymentDate": "2017-08-23"
                    },
                    "fromAccount": {
                      "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                      "iban": "RO95RZBR0000060017443357"
                    },
                    "taxDetails": {
                        "cnp": "1840404393612",
                        "taxCode": "21.A.16.03.00",
                        "evidenceNr": "12345678901234567890123",
                        "taxDescription": "Taxe si tarife pentru eliberarea de licente si autorizatii de functionare",
                        "taxBeneficiaryName": "Comuna Galda de Jos",
                        "taxBeneficiaryFiscalCode": "4561928"
                    }
                }
        - verify status 200 
        - verify pendingActionIds
        - extract pendingActionIds */

/*3. Payment status: GET /pending-action/status/{id}

        - verify status 200
        - verify response*/

/*4. Delete active payment: DELETE /active-payment

                {
                    "activePayments": [
                        {
                            "id": "0002052120-2017-06-29-131151-021",
                            "actionId": "0003"
                        },
                        {
                            "id": "0002052120-2017-06-29-130911-439",
                            "actionId": "0003"
                        },
                        {
                            "id": "0002052120-2017-06-29-131058-156",
                            "actionId": "0003"
                        }
                    ]
                }

            - verify status 200
            - verify response */

/*5. Clasify payment: POST /classify-payment

                {
                    "fromAccount": {
                        "currency": "RON",
                        "iban": "RO63RZBR0000060005161502"
                    },
                    "toAccount": {
                        "currency": "RON",
                        "iban": "RO50INGB0001008189548910"
                    },
                    "payer": {
                      "cif": "12345"
                    },
                    "payee": {
                      "cif": "12345"
                    }
                }

            - verify status 200
            - verfiy action id for each action type*/

/*6. Payment currencies: GET /currencies

            - verify status 200
            - verify responsy body ["EUR","USD","GBP","AUD","CAD","CHF","DKK","HUF","JPY","NOK","PLN","RON","SEK","BGN"]*/

/*7. Search: GET /search?query={search string}

            - verify stsatus 200 
            - verify response not empty 
            - verify fi search returns correctly*/

/*8. Validate BIC: GET /validate-bic/{BIC CODE}

            - verfiry status 200
            - verify corerct BIC corerct
            - verift incorect BIC*/

/*9. Western union input page prerequisites: GET /western-union/prerequisites

            - verify status 200
            - verify content */

/*10. Western Union confirm receive money: POST /western-union/receive-money

                {
                    "MTCN":"1200538130",
                    "expectedAmount":"10",
                    "expectedCurrency": "RON",
                    "originationCountry": "RO",
                    "account": "18058607",
                    "accountType": "52",
                    "productId": "54"
                }

            - verify status 200
            - verify response*/

11. Get Taxes prerequisites: GET /taxes-prerequisites

            - verify status 200
            - verify content 

12. Get Taxes list: GET /search/taxes-beneficiaries?type={beneficiaryType}&query={beneficiaryQuery}

            - verfiy status 200
            - verify response based on search

13. Active payments Instances: GET /active-payment/{activePaymentId}/instances?startFrom={startFrom}&maxRows={maxRows}

            - verify status 200
            - verify response based on params 

