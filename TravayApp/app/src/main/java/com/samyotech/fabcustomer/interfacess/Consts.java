package com.samyotech.fabcustomer.interfacess;

/**
 * Created by VARUN on 01/01/19.
 */

public interface Consts {
    String APP_NAME = "FabCustomer";
    //new 677440
    String BASE_URL = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/";
    String PAYMENT_FAIL = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/Payment/fail";
    String PAYMENT_SUCCESS = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/Payment/success";
    String MAKE_PAYMENT = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/Payment/make_payment/";

    String PAYMENT_FAIL_Paypal = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/payufailure";
    String PAYMENT_SUCCESS_paypal = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/payusuccess";
    String MAKE_PAYMENT_paypal = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/paypalWallent?";

    String INVOICE_PAYMENT_FAIL_Stripe = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/BookingPayement/fail";
    String INVOICE_PAYMENT_SUCCESS_Stripe = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/BookingPayement/success";
    String INVOICE_PAYMENT_Stripe = "http://phpstack-132936-852279.cloudwaysapps.com/Stripe/BookingPayement/make_payment/";

    String INVOICE__PAYMENT_paypal = " http://phpstack-132936-852279.cloudwaysapps.com/Webservice/paypal?";
    String PRIVACY_URL = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/privacy";
    String TERMS_URL = "http://phpstack-132936-852279.cloudwaysapps.com/Webservice/term";


    /*Api Details*/
    String GET_ALL_ARTISTS_API = "getAllArtists";
    String GET_ARTIST_BY_ID_API = "getArtistByid";
    String GET_NOTIFICATION_API = "getNotifications";
    String GET_INVOICE_API = "getMyInvoice";
    String GET_REFERRAL_CODE_API = "getMyReferralCode";
    String GET_CHAT_HISTORY_API = "getChatHistoryForUser";
    String GET_CHAT_API = "getChat";
    String SEND_CHAT_API = "sendmsg";
    String LOGIN_API = "signIn";
    String REGISTER_API = "SignUp";
    String UPDATE_PROFILE_API = "editPersonalInfo";
    String CURRENT_BOOKING_API = "getMyCurrentBookingUser";
    String BOOK_ARTIST_API = "book_artist";
    String BOOK_APPOINTMENT_API = "book_appointment";
    String DECLINE_BOOKING_API = "decline_booking";
    String UPDATE_LOCATION_API = "updateLocation";
    String MAKE_PAYMENT_API = "makePayment";
    String CHECK_COUPON_API = "checkCoupon";
    String GET_MY_TICKET_API = "getMyTicket";
    String GENERATE_TICKET_API = "generateTicket";
    String GET_TICKET_COMMENTS_API = "getTicketComments";
    String ADD_TICKET_COMMENTS_API = "addTicketComments";
    String FORGET_PASSWORD_API = "forgotPassword";
    String GET_APPOINTMENT_API = "getAppointment";
    String EDIT_APPOINTMENT_API = "edit_appointment";
    String APPOINTMENT_OPERATION_API = "appointment_operation";
    String GET_ALL_CATEGORY_API = "getAllCaegory";
    String GET_ALL_JOB_USER_API = "get_all_job_user";
    String POST_JOB_API = "post_job_new";
    String GET_APPLIED_JOB_BY_ID_API = "get_applied_job_by_id";
    String JOB_STATUS_USER_API = "job_status_user";
    String EDIT_POST_JOB_API = "edit_post_job";
    String DELETE_JOB_API = "deletejob";
    String ADD_FAVORITES_API = "add_favorites";
    String REMOVE_FAVORITES_API = "remove_favorites";
    String GET_LOCATION_ARTIST_API = "getLocationArtist";
    String ADD_RATING_API = "addRating";
    String BOOKING_OPERATION_API = "booking_operation";
    String JOB_COMPLETE_API = "jobComplete";
    String DELETE_PROFILE_IMAGE_API = "deleteProfileImage";
    String ADD_MONEY_API = "addMoney";
    String GET_WALLET_HISTORY_API = "getWalletHistory";
    String GET_WALLET_API = "getWallet";


    /*app data*/
    static String INTROAPP = "INTROAPP";
    String CAMERA_ACCEPTED = "camera_accepted";
    String STORAGE_ACCEPTED = "storage_accepted";
    String MODIFY_AUDIO_ACCEPTED = "modify_audio_accepted";
    String CALL_PRIVILAGE = "call_privilage";
    String FINE_LOC = "fine_loc";
    String CORAS_LOC = "coras_loc";
    String CALL_PHONE = "call_phone";
    String PAYMENT_URL = "payment_url";
    String SURL = "surl";
    String FURL = "furl";
    String SCREEN_TAG = "screen_tag";
    String SERVICE_ARRAY = "service_array";
    String DTO = "dto";
    String POSTION = "postion";
    String SURL_BOOKING = "surl_booking";
    String FURL_BOOKING = "furl_booking";
    static final String mBroadcastShowAdd = "FabCustomer.showAdd";
    /*app data*/

    /*Project Parameter*/
    String ARTIST_ID = "artist_id";
    String CHAT_LIST_DTO = "chat_list_dto";
    String USER_DTO = "user_dto";
    String POST_JOB_DTO = "post_job_dto";
    String IS_REGISTERED = "is_registered";
    String IMAGE_URI_CAMERA = "image_uri_camera";
    String DATE_FORMATE_SERVER = "EEE, MMM dd, yyyy hh:mm a"; //Wed, JUL 06, 2018 04:30 pm
    String DATE_FORMATE_TIMEZONE = "z";
    String HISTORY_DTO = "history_dto";
    String BROADCAST = "broadcast";
    String ARTIST_DTO = "artist_dto";
    String CATEGORY_list = "category_list";
    String FLAG = "flag";

    /*Parameter Get Artist and Search*/
    String USER_ID = "user_id";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String CATEGORY_ID = "category_id";

    /*Get All History*/
    String ROLE = "role";

    /*Send Message*/
    String MESSAGE = "message";
    String SEND_BY = "send_by";
    String SENDER_NAME = "sender_name";


    /*Login Parameter*/
    String NAME = "name";
    String EMAIL_ID = "email_id";
    String PASSWORD = "password";
    String DEVICE_TYPE = "device_type";
    String DEVICE_TOKEN = "device_token";
    String DEVICE_ID = "device_id";
    String REFERRAL_CODE = "referral_code";


    /*Update Profile*/
    String NEW_PASSWORD = "new_password";
    String GENDER = "gender";
    String MOBILE = "mobile";
    String OFFICE_ADDRESS = "office_address";
    String ADDRESS = "address";
    String IMAGE = "image";
    String CITY = "city";
    String COUNTRY = "country";

    /*Book Artist*/

    String DATE_STRING = "date_string";
    String TIMEZONE = "timezone";
    String PRICE = "price";
    String PLACE = "place";
    String ESTIMATE_TIME = "estimate_time";
    String SERVICE_ID = "service_id";
    /*Decline*/
    String BOOKING_ID = "booking_id";
    String DECLINE_BY = "decline_by";
    String DECLINE_REASON = "decline_reason";

    /*Make Payment*/
    String INVOICE_ID = "invoice_id";
    // String USER_ID = "user_id";
    String COUPON_CODE = "coupon_code";
    String FINAL_AMOUNT = "final_amount";
    String PAYMENT_STATUS = "payment_status";


    /*Chat intent*/
    String ARTIST_NAME = "artist_name";

    /*Add Ticket*/
    String REASON = "reason";


    /*Get Ticket*/
    String TICKET_ID = "ticket_id";
    String COMMENT = "comment";


    /*Edit Appointment*/
    String APPOINTMENT_ID = "appointment_id";

    /*Decline Appointment*/
    String REQUEST = "request";


    /*Post Job*/
    String AVTAR = "avtar";
    String TITLE = "title";
    String DESCRIPTION = "description";
    String LATI = "lati";
    String LONGI = "longi";
    String JOB_DATE = "job_date";

    /*Get Applied Job*/
    String JOB_ID = "job_id";
    String aj_id = "aj_id";

    /*Job Status*/
    String AJ_ID = "aj_id";
    String STATUS = "status";

    // Google Console APIs developer key
    // Replace this key with your's
    static final String DEVELOPER_KEY = "AIzaSyBlLIsCaCw8ylCTPR0XhaKp-vkeD4S-5_0";


    /*Payment*/
    String PAYMENT_TYPE = "payment_type";
    String DISCOUNT_AMOUNT = "discount_amount";
    /*Chat*/
    String CHAT_TYPE = "chat_type";

    /*Paypal Client Id*/
    /*Add Review*/
    String RATING = "rating";


    /*Add Money*/
    String TXN_ID = "txn_id";
    String ORDER_ID = "order_id";
    String AMOUNT = "amount";
    String CURRENCY = "currency";

    /*Notifications Codes*/
    String BOOK_ARTIST_NOTIFICATION = "10001";//ar
    String DECLINE_BOOKING_ARTIST_NOTIFICATION = "10002";//both
    String START_BOOKING_ARTIST_NOTIFICATION = "10003";
    String END_BOOKING_ARTIST_NOTIFICATION = "10004";//user
    String CANCEL_BOOKING_ARTIST_NOTIFICATION = "10005";
    String ACCEPT_BOOKING_ARTIST_NOTIFICATION = "10006";//user
    String CHAT_NOTIFICATION = "10007";//both
    String USER_BLOCK_NOTIFICATION = "1008";
    String TICKET_COMMENT_NOTIFICATION = "10009";//both
    String WALLET_NOTIFICATION = "10010";//both
    String JOB_NOTIFICATION = "10011";//ar
    String JOB_APPLY_NOTIFICATION = "10012";//user
    String DELETE_JOB_NOTIFICATION = "10013";//ar
    String BRODCAST_NOTIFICATION = "10014";//both
    String TICKET_STATUS_NOTIFICATION = "10015";//both
    String ADMIN_NOTIFICATION = "10016";
    String TYPE = "type";
    String TOPIC_CUSTOMER = "Customer";


    /*Api Details*/


    String UPDATE_PROFILE_ARTIST_API = "artistPrsonalInfo";

    String GET_ALL_SKILLS_BY_CAT_API = "getSkillsByCategory";
    String ADD_QUALIFICATION_API = "addQualification";
    String ADD_PRODUCT_API = "addProduct";
    String ADD_GALLERY_API = "addGallery";

    String ONLINE_OFFLINE_API = "onlineOffline";

    String ARTIST_LOGOUT_API = "artistLogout";

    String GET_ALL_JOB_API = "get_all_job";
    String APPLIED_JOB_API = "applied_job";
    String JOB_STATUS_ARTIST_API = "job_status_artist";
    String GET_APPLIED_JOB_ARTIST_API = "get_applied_job_artist";
    String CHANGE_COMMISSION_ARTIST_API = "changeCommissionArtist";
    String START_JOB_API = "startJob";

    String MY_EARNING1_API = "myEarning1";
    String WALLET_REQUEST_API = "walletRequest";

    String DELETE_GALLERY_API = "deleteGallery";
    String DELETE_PRODUCT_API = "deleteProduct";
    String UPDATE_QUALIFICATION_API = "updateQualification";
    String DELETE_QUALIFICATION_API = "deleteQualification";
    String GET_ALL_BOOKING_ARTIST_API = "getAllBookingArtist";
    String GET_APPROVAL_STATUS_API = "getApprovalStatus";


    /*app data*/

    /*Project Parameter*/

    String LOCATION1 = "location1";
    String PRODUCT_ID = "product_id";
    String BOOKING_FLAG = "booking_flag";


    /*Parameter Get Artist and Search*/

    String ID = "id";


    /*Update Profile Artist*/

    String BIO = "bio";
    String LOCATION = "location";

    String ABOUT_US = "about_us";
    String SKILLS = "skills";
    String VIDEO_URL = "video_url";

    String BANNER_IMAGE = "banner_image";

    /*Get Skills*/
    String CAT_ID = "cat_id";


    /*Update Qualification*/

    String QUALIFICATION_ID = "qualification_id";

    /*Update Qualification*/
    String PRODUCT_NAME = "product_name";
    String PRODUCT_IMAGE = "product_image";


    /*Online Offline*/
    String IS_ONLINE = "is_online";


    /*Payment Type*/
    String ARTIST_COMMISSION_TYPE = "artist_commission_type";





    String TOPIC_ARTIST = "Artist";
}

