package com.sentrytechnologies.bobbydouglass.watchdogmt;

public class Modbus_Values {

    /* **************************** MODBUS VALUE **************************** */

    /* ************** 035 ********* Modbus 10000 ********* 035 ************** */
    public static final short modbus_id_for_slave           = 0;            // 10000
    public static final short enable_ttl_smartone           = 2;            // 10001
    public static final short mikrobus_1_device_type        = 0;            // 10002
    public static final short mikrobus_1_comm_proto         = 0;            // 10003
    public static final short mikrobus_1_floaterface        = 0;            // 10004
    public static final short mikrobus_1_rs232_baud         = 0;            // 10005
    public static final short mikrobus_1_rs232_parity       = 0;            // 10006
    public static final short mikrobus_1_rs232_data         = 8;            // 10007
    public static final short mikrobus_1_rs232_stop         = 1;            // 10008
    public static final short mikrobus_2_device_type        = 0;            // 10009
    public static final short mikrobus_2_comm_proto         = 1;            // 10010
    public static final short mikrobus_2_floaterface        = 0;            // 10011
    public static final short mikrobus_2_rs232_baud         = 0;            // 10012
    public static final short mikrobus_2_rs232_parity       = 0;            // 10013
    public static final short mikrobus_2_rs232_data         = 8;            // 10014
    public static final short mikrobus_2_rs232_stop         = 1;            // 10015
    public static final short rs485_floaterface_mode        = 1;            // 10016
    public static final short rs485_baud_rate               = 0;            // 10017
    public static final short rs485_parity_bit              = 0;            // 10018
    public static final short rs485_data_bits               = 8;            // 10019
    public static final short rs485_stop_bits               = 1;            // 10020
    public static final short auto_reports_per_day          = 2;            // 10021
    public static final short diag_reports_per_month        = 4;            // 10022
    public static final short power_mode                    = 0;            // 10025
    public static final short rtc_seconds                   = 0;            // 10026
    public static final short rtc_minutes                   = 0;            // 10027
    public static final short rtc_hours                     = 0;            // 10028
    public static final short rtc_day_of_month              = 1;            // 10029
    public static final short rtc_month                     = 1;            // 10030
    public static final short rtc_year                      = 2017;         // 10031
    public static final short rtc_day_light_savings         = 0;            // 10032
    public static final short rtc_time_zone                 = 5;            // 10033
    public static final short enable_nfc_security           = 0;            // 10034
    public static final short enable_rs232_security         = 0;            // 10035
    public static final short phone_programming_revision    = 0;            // 10036
    /* ************** 035 ********* Modbus 10000 ********* 035 ************** */

    /* ************** 008 ********* Modbus 10100 ********* 008 ************** */
    public static final short li_1_mode                     = 1;            // 10100
    public static final short li_2_mode                     = 1;            // 10102
    public static final short li_3_mode                     = 1;            // 10104
    public static final short li_4_mode                     = 1;            // 10106
    public static final short li_5_mode                     = 1;            // 10108
    public static final short li_6_mode                     = 1;            // 10110
    public static final short li_7_mode                     = 1;            // 10112
    public static final short li_8_mode                     = 1;            // 10114
    /* ************** 008 ********* Modbus 10100 ********* 008 ************** */

    /* ************** 144 ********* Modbus 10200 ********* 144 ************** */
    public static final short mod_reg_1_enable_id           = 0;            // 10200
    public static final short mod_reg_1_command             = 2;            // 10201
    public static final short mod_reg_1_address             = 0;            // 10202
    public static final short mod_reg_1_data_format         = 1;            // 10203
    public static final short mod_reg_1_alarm_config        = 3;            // 10204
    public static final short mod_reg_1_output_options      = 0;            // 10205
    public static final short mod_reg_2_enable_id           = 0;            // 10206
    public static final short mod_reg_2_command             = 2;            // 10207
    public static final short mod_reg_2_address             = 0;            // 10208
    public static final short mod_reg_2_data_format         = 1;            // 10209
    public static final short mod_reg_2_alarm_config        = 3;            // 10210
    public static final short mod_reg_2_output_options      = 0;            // 10211
    public static final short mod_reg_3_enable_id           = 0;            // 10212
    public static final short mod_reg_3_command             = 2;            // 10213
    public static final short mod_reg_3_address             = 0;            // 10214
    public static final short mod_reg_3_data_format         = 1;            // 10215
    public static final short mod_reg_3_alarm_config        = 3;            // 10216
    public static final short mod_reg_3_output_options      = 0;            // 10217
    public static final short mod_reg_4_enable_id           = 0;            // 10218
    public static final short mod_reg_4_command             = 2;            // 10219
    public static final short mod_reg_4_address             = 0;            // 10220
    public static final short mod_reg_4_data_format         = 1;            // 10221
    public static final short mod_reg_4_alarm_config        = 3;            // 10222
    public static final short mod_reg_4_output_options      = 0;            // 10223
    public static final short mod_reg_5_enable_id           = 0;            // 10224
    public static final short mod_reg_5_command             = 2;            // 10225
    public static final short mod_reg_5_address             = 0;            // 10226
    public static final short mod_reg_5_data_format         = 1;            // 10227
    public static final short mod_reg_5_alarm_config        = 3;            // 10228
    public static final short mod_reg_5_output_options      = 0;            // 10229
    public static final short mod_reg_6_enable_id           = 0;            // 10230
    public static final short mod_reg_6_command             = 2;            // 10231
    public static final short mod_reg_6_address             = 0;            // 10232
    public static final short mod_reg_6_data_format         = 1;            // 10233
    public static final short mod_reg_6_alarm_config        = 3;            // 10234
    public static final short mod_reg_6_output_options      = 0;            // 10235
    public static final short mod_reg_7_enable_id           = 0;            // 10236
    public static final short mod_reg_7_command             = 2;            // 10237
    public static final short mod_reg_7_address             = 0;            // 10238
    public static final short mod_reg_7_data_format         = 1;            // 10239
    public static final short mod_reg_7_alarm_config        = 3;            // 10240
    public static final short mod_reg_7_output_options      = 0;            // 10241
    public static final short mod_reg_8_enable_id           = 0;            // 10242
    public static final short mod_reg_8_command             = 2;            // 10243
    public static final short mod_reg_8_address             = 0;            // 10244
    public static final short mod_reg_8_data_format         = 1;            // 10245
    public static final short mod_reg_8_alarm_config        = 3;            // 10246
    public static final short mod_reg_8_output_options      = 0;            // 10247
    public static final short mod_reg_9_enable_id           = 0;            // 10248
    public static final short mod_reg_9_command             = 2;            // 10249
    public static final short mod_reg_9_address             = 0;            // 10250
    public static final short mod_reg_9_data_format         = 1;            // 10251
    public static final short mod_reg_9_alarm_config        = 3;            // 10252
    public static final short mod_reg_9_output_options      = 0;            // 10253
    public static final short mod_reg_10_enable_id          = 0;            // 10254
    public static final short mod_reg_10_command            = 2;            // 10255
    public static final short mod_reg_10_address            = 0;            // 10256
    public static final short mod_reg_10_data_format        = 1;            // 10257
    public static final short mod_reg_10_alarm_config       = 3;            // 10258
    public static final short mod_reg_10_output_options     = 0;            // 10259
    public static final short mod_reg_11_enable_id          = 0;            // 10260
    public static final short mod_reg_11_command            = 2;            // 10261
    public static final short mod_reg_11_address            = 0;            // 10262
    public static final short mod_reg_11_data_format        = 1;            // 10263
    public static final short mod_reg_11_alarm_config       = 3;            // 10264
    public static final short mod_reg_11_output_options     = 0;            // 10265
    public static final short mod_reg_12_enable_id          = 0;            // 10266
    public static final short mod_reg_12_command            = 2;            // 10267
    public static final short mod_reg_12_address            = 0;            // 10268
    public static final short mod_reg_12_data_format        = 1;            // 10269
    public static final short mod_reg_12_alarm_config       = 3;            // 10270
    public static final short mod_reg_12_output_options     = 0;            // 10271
    public static final short mod_reg_13_enable_id          = 0;            // 10272
    public static final short mod_reg_13_command            = 2;            // 10273
    public static final short mod_reg_13_address            = 0;            // 10274
    public static final short mod_reg_13_data_format        = 1;            // 10275
    public static final short mod_reg_13_alarm_config       = 3;            // 10276
    public static final short mod_reg_13_output_options     = 0;            // 10277
    public static final short mod_reg_14_enable_id          = 0;            // 10278
    public static final short mod_reg_14_command            = 2;            // 10279
    public static final short mod_reg_14_address            = 0;            // 10280
    public static final short mod_reg_14_data_format        = 1;            // 10281
    public static final short mod_reg_14_alarm_config       = 3;            // 10282
    public static final short mod_reg_14_output_options     = 0;            // 10283
    public static final short mod_reg_15_enable_id          = 0;            // 10284
    public static final short mod_reg_15_command            = 2;            // 10285
    public static final short mod_reg_15_address            = 0;            // 10286
    public static final short mod_reg_15_data_format        = 1;            // 10287
    public static final short mod_reg_15_alarm_config       = 3;            // 10288
    public static final short mod_reg_15_output_options     = 0;            // 10289
    public static final short mod_reg_16_enable_id          = 0;            // 10290
    public static final short mod_reg_16_command            = 2;            // 10291
    public static final short mod_reg_16_address            = 0;            // 10292
    public static final short mod_reg_16_data_format        = 1;            // 10293
    public static final short mod_reg_16_alarm_config       = 3;            // 10294
    public static final short mod_reg_16_output_options     = 0;            // 10295
    public static final short mod_reg_17_enable_id          = 0;            // 10296
    public static final short mod_reg_17_command            = 2;            // 10297
    public static final short mod_reg_17_address            = 0;            // 10298
    public static final short mod_reg_17_data_format        = 1;            // 10299
    public static final short mod_reg_17_alarm_config       = 3;            // 10300
    public static final short mod_reg_17_output_options     = 0;            // 10301
    public static final short mod_reg_18_enable_id          = 0;            // 10302
    public static final short mod_reg_18_command            = 2;            // 10303
    public static final short mod_reg_18_address            = 0;            // 10304
    public static final short mod_reg_18_data_format        = 1;            // 10305
    public static final short mod_reg_18_alarm_config       = 3;            // 10306
    public static final short mod_reg_18_output_options     = 0;            // 10307
    public static final short mod_reg_19_enable_id          = 0;            // 10308
    public static final short mod_reg_19_command            = 2;            // 10309
    public static final short mod_reg_19_address            = 0;            // 10310
    public static final short mod_reg_19_data_format        = 1;            // 10311
    public static final short mod_reg_19_alarm_config       = 3;            // 10312
    public static final short mod_reg_19_output_options     = 0;            // 10313
    public static final short mod_reg_20_enable_id          = 0;            // 10314
    public static final short mod_reg_20_command            = 2;            // 10315
    public static final short mod_reg_20_address            = 0;            // 10316
    public static final short mod_reg_20_data_format        = 1;            // 10317
    public static final short mod_reg_20_alarm_config       = 3;            // 10318
    public static final short mod_reg_20_output_options     = 0;            // 10319
    public static final short mod_reg_21_enable_id          = 0;            // 10320
    public static final short mod_reg_21_command            = 2;            // 10321
    public static final short mod_reg_21_address            = 0;            // 10322
    public static final short mod_reg_21_data_format        = 1;            // 10323
    public static final short mod_reg_21_alarm_config       = 3;            // 10324
    public static final short mod_reg_21_output_options     = 0;            // 10325
    public static final short mod_reg_22_enable_id          = 0;            // 10326
    public static final short mod_reg_22_command            = 2;            // 10327
    public static final short mod_reg_22_address            = 0;            // 10328
    public static final short mod_reg_22_data_format        = 1;            // 10329
    public static final short mod_reg_22_alarm_config       = 3;            // 10330
    public static final short mod_reg_22_output_options     = 0;            // 10331
    public static final short mod_reg_23_enable_id          = 0;            // 10332
    public static final short mod_reg_23_command            = 2;            // 10333
    public static final short mod_reg_23_address            = 0;            // 10334
    public static final short mod_reg_23_data_format        = 1;            // 10335
    public static final short mod_reg_23_alarm_config       = 3;            // 10336
    public static final short mod_reg_23_output_options     = 0;            // 10337
    public static final short mod_reg_24_enable_id          = 0;            // 10338
    public static final short mod_reg_24_command            = 2;            // 10339
    public static final short mod_reg_24_address            = 0;            // 10340
    public static final short mod_reg_24_data_format        = 1;            // 10341
    public static final short mod_reg_24_alarm_config       = 3;            // 10342
    public static final short mod_reg_24_output_options     = 0;            // 10343
    /* ************** 144 ********* Modbus 10200 ********* 144 ************** */

    /* ************** 008 ********* Modbus 12000 ********* 008 ************** */
    public static final short li_1_recog_time               = 3;            // 12000
    public static final short li_2_recog_time               = 3;            // 12001
    public static final short li_3_recog_time               = 3;            // 12002
    public static final short li_4_recog_time               = 3;            // 12003
    public static final short li_5_recog_time               = 3;            // 12004
    public static final short li_6_recog_time               = 3;            // 12005
    public static final short li_7_recog_time               = 3;            // 12006
    public static final short li_8_recog_time               = 3;            // 12007
    /* ************** 008 ********* Modbus 12000 ********* 008 ************** */

    /* ************** 154 ********* Modbus 12100 ********* 154 ************** */
    public static final short sm_no_reply_count             = 0;            // 12100
    public static final short sm_bad_reply_count            = 0;            // 12101
    public static final short mikrobus_1_no_reply_count     = 0;            // 12102
    public static final short mikrobus_1_bad_reply_count    = 0;            // 12103
    public static final short mikrobus_2_no_reply_count     = 0;            // 12104
    public static final short mikrobus_2_bad_reply_count    = 0;            // 12105
    public static final short mod_reg_1_no_reply_count      = 0;            // 12106
    public static final short mod_reg_1_bad_reply_count     = 0;            // 12107
    public static final short mod_reg_2_no_reply_count      = 0;            // 12108
    public static final short mod_reg_2_bad_reply_count     = 0;            // 12109
    public static final short mod_reg_3_no_reply_count      = 0;            // 12110
    public static final short mod_reg_3_bad_reply_count     = 0;            // 12111
    public static final short mod_reg_4_no_reply_count      = 0;            // 12112
    public static final short mod_reg_4_bad_reply_count     = 0;            // 12113
    public static final short mod_reg_5_no_reply_count      = 0;            // 12114
    public static final short mod_reg_5_bad_reply_count     = 0;            // 12115
    public static final short mod_reg_6_no_reply_count      = 0;            // 12116
    public static final short mod_reg_6_bad_reply_count     = 0;            // 12117
    public static final short mod_reg_7_no_reply_count      = 0;            // 12118
    public static final short mod_reg_7_bad_reply_count     = 0;            // 12119
    public static final short mod_reg_8_no_reply_count      = 0;            // 12120
    public static final short mod_reg_8_bad_reply_count     = 0;            // 12121
    public static final short mod_reg_9_no_reply_count      = 0;            // 12122
    public static final short mod_reg_9_bad_reply_count     = 0;            // 12123
    public static final short mod_reg_10_no_reply_count     = 0;            // 12124
    public static final short mod_reg_10_bad_reply_count    = 0;            // 12125
    public static final short mod_reg_11_no_reply_count     = 0;            // 12126
    public static final short mod_reg_11_bad_reply_count    = 0;            // 12127
    public static final short mod_reg_12_no_reply_count     = 0;            // 12128
    public static final short mod_reg_12_bad_reply_count    = 0;            // 12129
    public static final short mod_reg_13_no_reply_count     = 0;            // 12130
    public static final short mod_reg_13_bad_reply_count    = 0;            // 12131
    public static final short mod_reg_14_no_reply_count     = 0;            // 12132
    public static final short mod_reg_14_bad_reply_count    = 0;            // 12133
    public static final short mod_reg_15_no_reply_count     = 0;            // 12134
    public static final short mod_reg_15_bad_reply_count    = 0;            // 12135
    public static final short mod_reg_16_no_reply_count     = 0;            // 12136
    public static final short mod_reg_16_bad_reply_count    = 0;            // 12137
    public static final short mod_reg_17_no_reply_count     = 0;            // 12138
    public static final short mod_reg_17_bad_reply_count    = 0;            // 12139
    public static final short mod_reg_18_no_reply_count     = 0;            // 12140
    public static final short mod_reg_18_bad_reply_count    = 0;            // 12141
    public static final short mod_reg_19_no_reply_count     = 0;            // 12142
    public static final short mod_reg_19_bad_reply_count    = 0;            // 12143
    public static final short mod_reg_20_no_reply_count     = 0;            // 12144
    public static final short mod_reg_20_bad_reply_count    = 0;            // 12145
    public static final short mod_reg_21_no_reply_count     = 0;            // 12146
    public static final short mod_reg_21_bad_reply_count    = 0;            // 12147
    public static final short mod_reg_22_no_reply_count     = 0;            // 12148
    public static final short mod_reg_22_bad_reply_count    = 0;            // 12149
    public static final short mod_reg_23_no_reply_count     = 0;            // 12150
    public static final short mod_reg_23_bad_reply_count    = 0;            // 12151
    public static final short mod_reg_24_no_reply_count     = 0;            // 12152
    public static final short mod_reg_24_bad_reply_count    = 0;            // 12153
    /* ************** 154 ********* Modbus 12100 ********* 154 ************** */

    /* ************** 032 ********* Modbus 13000 ********* 032 ************** */
    public static final int li_1_pulse_today                = 0;            // 13000
    public static final int li_1_pulse_yesterday            = 0;            // 13001
    public static final int li_1_pulse_this_month           = 0;            // 13002
    public static final int li_1_pulse_last_month           = 0;            // 13003
    public static final int li_2_pulse_today                = 0;            // 13004
    public static final int li_2_pulse_yesterday            = 0;            // 13005
    public static final int li_2_pulse_this_month           = 0;            // 13006
    public static final int li_2_pulse_last_month           = 0;            // 13007
    public static final int li_3_pulse_today                = 0;            // 13008
    public static final int li_3_pulse_yesterday            = 0;            // 13009
    public static final int li_3_pulse_this_month           = 0;            // 13010
    public static final int li_3_pulse_last_month           = 0;            // 13011
    public static final int li_4_pulse_today                = 0;            // 13012
    public static final int li_4_pulse_yesterday            = 0;            // 13013
    public static final int li_4_pulse_this_month           = 0;            // 13014
    public static final int li_4_pulse_last_month           = 0;            // 13015
    public static final int li_5_pulse_today                = 0;            // 13016
    public static final int li_5_pulse_yesterday            = 0;            // 13017
    public static final int li_5_pulse_this_month           = 0;             // 13018
    public static final int li_5_pulse_last_month           = 0;            // 13019
    public static final int li_6_pulse_today                = 0;            // 13020
    public static final int li_6_pulse_yesterday            = 0;            // 13021
    public static final int li_6_pulse_this_month           = 0;            // 13022
    public static final int li_6_pulse_last_month           = 0;            // 13023
    public static final int li_7_pulse_today                = 0;            // 13024
    public static final int li_7_pulse_yesterday            = 0;            // 13025
    public static final int li_7_pulse_this_month           = 0;            // 13026
    public static final int li_7_pulse_last_month           = 0;            // 13027
    public static final int li_8_pulse_today                = 0;            // 13028
    public static final int li_8_pulse_yesterday            = 0;            // 13029
    public static final int li_8_pulse_this_month           = 0;            // 13030
    public static final int li_8_pulse_last_month           = 0;            // 13031
    /* ************** 032 ********* Modbus 13000 ********* 032 ************** */

    /* ************** 008 ********* Modbus 14000 ********* 008 ************** */
    public static final float li_1_pulse_mult           = 1;            // 14000
    public static final float li_2_pulse_mult           = 1;            // 14001
    public static final float li_3_pulse_mult           = 1;            // 14002
    public static final float li_4_pulse_mult           = 1;            // 14003
    public static final float li_5_pulse_mult           = 1;            // 14004
    public static final float li_6_pulse_mult           = 1;            // 14005
    public static final float li_7_pulse_mult           = 1;            // 14006
    public static final float li_8_pulse_mult           = 1;            // 14007
    /* ************** 008 ********* Modbus 14000 ********* 008 ************** */

    /* ************** 072 ********* Modbus 14100 ********* 072 ************** */
    public static final float mod_reg_1_low             = 0;            // 14100
    public static final float mod_reg_1_high            = 100;          // 14101
    public static final float mod_reg_1_calibration     = 0;            // 14102
    public static final float mod_reg_2_low             = 0;            // 14105
    public static final float mod_reg_2_high            = 100;          // 14106
    public static final float mod_reg_2_calibration     = 0;            // 14107
    public static final float mod_reg_3_low             = 0;            // 14110
    public static final float mod_reg_3_high            = 100;          // 14111
    public static final float mod_reg_3_calibration     = 0;            // 14112
    public static final float mod_reg_4_low             = 0;            // 14115
    public static final float mod_reg_4_high            = 100;          // 14116
    public static final float mod_reg_4_calibration     = 0;            // 14117
    public static final float mod_reg_5_low             = 0;            // 14120
    public static final float mod_reg_5_high            = 100;          // 14121
    public static final float mod_reg_5_calibration     = 0;            // 14122
    public static final float mod_reg_6_low             = 0;            // 14125
    public static final float mod_reg_6_high            = 100;          // 14126
    public static final float mod_reg_6_calibration     = 0;            // 14127
    public static final float mod_reg_7_low             = 0;            // 14130
    public static final float mod_reg_7_high            = 100;          // 14131
    public static final float mod_reg_7_calibration     = 0;            // 14132
    public static final float mod_reg_8_low             = 0;            // 14135
    public static final float mod_reg_8_high            = 100;          // 14136
    public static final float mod_reg_8_calibration     = 0;            // 14137
    public static final float mod_reg_9_low             = 0;            // 14140
    public static final float mod_reg_9_high            = 100;          // 14141
    public static final float mod_reg_9_calibration     = 0;            // 14142
    public static final float mod_reg_10_low            = 0;            // 14145
    public static final float mod_reg_10_high           = 100;          // 14146
    public static final float mod_reg_10_calibration    = 0;            // 14147
    public static final float mod_reg_11_low            = 0;            // 14150
    public static final float mod_reg_11_high           = 100;          // 14151
    public static final float mod_reg_11_calibration    = 0;            // 14152
    public static final float mod_reg_12_low            = 0;            // 14155
    public static final float mod_reg_12_high           = 100;          // 14156
    public static final float mod_reg_12_calibration    = 0;            // 14157
    public static final float mod_reg_13_low            = 0;            // 14160
    public static final float mod_reg_13_high           = 100;          // 14161
    public static final float mod_reg_13_calibration    = 0;            // 14162
    public static final float mod_reg_14_low            = 0;            // 14165
    public static final float mod_reg_14_high           = 100;          // 14166
    public static final float mod_reg_14_calibration    = 0;            // 14167
    public static final float mod_reg_15_low            = 0;            // 14170
    public static final float mod_reg_15_high           = 100;          // 14171
    public static final float mod_reg_15_calibration    = 0;            // 14172
    public static final float mod_reg_16_low            = 0;            // 14175
    public static final float mod_reg_16_high           = 100;          // 14176
    public static final float mod_reg_16_calibration    = 0;            // 14177
    public static final float mod_reg_17_low            = 0;            // 14180
    public static final float mod_reg_17_high           = 100;          // 14181
    public static final float mod_reg_17_calibration    = 0;            // 14182
    public static final float mod_reg_18_low            = 0;            // 14185
    public static final float mod_reg_18_high           = 100;          // 14186
    public static final float mod_reg_18_calibration    = 0;            // 14187
    public static final float mod_reg_19_low            = 0;            // 14190
    public static final float mod_reg_19_high           = 100;          // 14191
    public static final float mod_reg_19_calibration    = 0;            // 14192
    public static final float mod_reg_20_low            = 0;            // 14195
    public static final float mod_reg_20_high           = 100;          // 14196
    public static final float mod_reg_20_calibration    = 0;            // 14197
    public static final float mod_reg_21_low            = 0;            // 14200
    public static final float mod_reg_21_high           = 100;          // 14201
    public static final float mod_reg_21_calibration    = 0;            // 14202
    public static final float mod_reg_22_low            = 0;            // 14205
    public static final float mod_reg_22_high           = 100;          // 14206
    public static final float mod_reg_22_calibration    = 0;            // 14207
    public static final float mod_reg_23_low            = 0;            // 14210
    public static final float mod_reg_23_high           = 100;          // 14211
    public static final float mod_reg_23_calibration    = 0;            // 14212
    public static final float mod_reg_24_low            = 0;            // 14215
    public static final float mod_reg_24_high           = 100;          // 14216
    public static final float mod_reg_24_calibration    = 0;            // 14217
    /* ************** 072 ********* Modbus 14100 ********* 072 ************** */

    /* ************** 032 ********* Modbus 15600 ********* 032 ************** */
    public static final String li_1_uom                 = "";           // 15600
    public static final String li_2_uom                 = "";           // 15601
    public static final String li_3_uom                 = "";           // 15602
    public static final String li_4_uom                 = "";           // 15603
    public static final String li_5_uom                 = "";           // 15604
    public static final String li_6_uom                 = "";           // 15605
    public static final String li_7_uom                 = "";           // 15606
    public static final String li_8_uom                 = "";           // 15607
    public static final String mod_reg_1_uom            = "";           // 15608
    public static final String mod_reg_2_uom            = "";           // 15609
    public static final String mod_reg_3_uom            = "";           // 15610
    public static final String mod_reg_4_uom            = "";           // 15611
    public static final String mod_reg_5_uom            = "";           // 15612
    public static final String mod_reg_6_uom            = "";           // 15613
    public static final String mod_reg_7_uom            = "";           // 15614
    public static final String mod_reg_8_uom            = "";           // 15615
    public static final String mod_reg_9_uom            = "";           // 15616
    public static final String mod_reg_10_uom           = "";           // 15617
    public static final String mod_reg_11_uom           = "";           // 15618
    public static final String mod_reg_12_uom           = "";           // 15619
    public static final String mod_reg_13_uom           = "";           // 15620
    public static final String mod_reg_14_uom           = "";           // 15621
    public static final String mod_reg_15_uom           = "";           // 15622
    public static final String mod_reg_16_uom           = "";           // 15623
    public static final String mod_reg_17_uom           = "";           // 15624
    public static final String mod_reg_18_uom           = "";           // 15625
    public static final String mod_reg_19_uom           = "";           // 15626
    public static final String mod_reg_20_uom           = "";           // 15627
    public static final String mod_reg_21_uom           = "";           // 15628
    public static final String mod_reg_22_uom           = "";           // 15629
    public static final String mod_reg_23_uom           = "";           // 15630
    public static final String mod_reg_24_uom           = "";           // 15631
    /* ************** 032 ********* Modbus 15600 ********* 032 ************** */

    /* ************** 032 ********* Modbus 16000 ********* 032 ************** */
    public static final String li_1_name                = "Input 1";    // 16000
    public static final String li_2_name                = "Input 2";    // 16001
    public static final String li_3_name                = "Input 3";    // 16002
    public static final String li_4_name                = "Input 4";    // 16003
    public static final String li_5_name                = "Input 5";    // 16004
    public static final String li_6_name                = "Input 6";    // 16005
    public static final String li_7_name                = "Input 7";    // 16006
    public static final String li_8_name                = "Input 8";    // 16007
    public static final String mod_reg_1_name           = "Modbus 1";   // 16008
    public static final String mod_reg_2_name           = "Modbus 2";   // 16009
    public static final String mod_reg_3_name           = "Modbus 3";   // 16010
    public static final String mod_reg_4_name           = "Modbus 4";   // 16011
    public static final String mod_reg_5_name           = "Modbus 5";   // 16012
    public static final String mod_reg_6_name           = "Modbus 6";   // 16013
    public static final String mod_reg_7_name           = "Modbus 7";   // 16014
    public static final String mod_reg_8_name           = "Modbus 8";   // 16015
    public static final String mod_reg_9_name           = "Modbus 9";   // 16016
    public static final String mod_reg_10_name          = "Modbus 10";  // 16017
    public static final String mod_reg_11_name          = "Modbus 11";  // 16018
    public static final String mod_reg_12_name          = "Modbus 12";  // 16019
    public static final String mod_reg_13_name          = "Modbus 13";  // 16020
    public static final String mod_reg_14_name          = "Modbus 14";  // 16021
    public static final String mod_reg_15_name          = "Modbus 15";  // 16022
    public static final String mod_reg_16_name          = "Modbus 16";  // 16023
    public static final String mod_reg_17_name          = "Modbus 17";  // 16024
    public static final String mod_reg_18_name          = "Modbus 18";  // 16025
    public static final String mod_reg_19_name          = "Modbus 19";  // 16026
    public static final String mod_reg_20_name          = "Modbus 20";  // 16027
    public static final String mod_reg_21_name          = "Modbus 21";  // 16028
    public static final String mod_reg_22_name          = "Modbus 22";  // 16029
    public static final String mod_reg_23_name          = "Modbus 23";  // 16030
    public static final String mod_reg_24_name          = "Modbus 24";  // 16031
    /* ************** 032 ********* Modbus 16000 ********* 032 ************** */

    /* **************************** MODBUS VALUE **************************** */

    public static final short Size_1 = 249;
    public static final short Size_2 = 32;
    public static final short Size_3 = 80;
    public static final short Size_4 = 64;

    public static short[] Modbus_1 =   {modbus_id_for_slave,        enable_ttl_smartone,        mikrobus_1_device_type,     mikrobus_1_comm_proto,
            mikrobus_1_floaterface,     mikrobus_1_rs232_baud,      mikrobus_1_rs232_parity,    mikrobus_1_rs232_data,      mikrobus_1_rs232_stop,
            mikrobus_2_device_type,     mikrobus_2_comm_proto,      mikrobus_2_floaterface,     mikrobus_2_rs232_baud,      mikrobus_2_rs232_parity,
            mikrobus_2_rs232_data,      mikrobus_2_rs232_stop,      rs485_floaterface_mode,     rs485_baud_rate,            rs485_parity_bit,
            rs485_data_bits,            rs485_stop_bits,            auto_reports_per_day,       diag_reports_per_month,     power_mode,
            rtc_seconds,                rtc_minutes,                rtc_hours,                  rtc_day_of_month,           rtc_month,
            rtc_year,                   rtc_day_light_savings,      rtc_time_zone,              enable_nfc_security,        enable_rs232_security,
            phone_programming_revision, li_1_mode,                  li_2_mode,                  li_3_mode,                  li_4_mode,
            li_5_mode,                  li_6_mode,                  li_7_mode,                  li_8_mode,                  mod_reg_1_enable_id,
            mod_reg_1_command,          mod_reg_1_address,          mod_reg_1_data_format,      mod_reg_1_alarm_config,     mod_reg_1_output_options,
            mod_reg_2_enable_id,        mod_reg_2_command,          mod_reg_2_address,          mod_reg_2_data_format,      mod_reg_2_alarm_config,
            mod_reg_2_output_options,   mod_reg_3_enable_id,        mod_reg_3_command,          mod_reg_3_address,          mod_reg_3_data_format,
            mod_reg_3_alarm_config,     mod_reg_3_output_options,   mod_reg_4_enable_id,        mod_reg_4_command,          mod_reg_4_address,
            mod_reg_4_data_format,      mod_reg_4_alarm_config,     mod_reg_4_output_options,   mod_reg_5_enable_id,        mod_reg_5_command,
            mod_reg_5_address,          mod_reg_5_data_format,      mod_reg_5_alarm_config,     mod_reg_5_output_options,   mod_reg_6_enable_id,
            mod_reg_6_command,          mod_reg_6_address,          mod_reg_6_data_format,      mod_reg_6_alarm_config,     mod_reg_6_output_options,
            mod_reg_7_enable_id,        mod_reg_7_command,          mod_reg_7_address,          mod_reg_7_data_format,      mod_reg_7_alarm_config,
            mod_reg_7_output_options,   mod_reg_8_enable_id,        mod_reg_8_command,          mod_reg_8_address,          mod_reg_8_data_format,
            mod_reg_8_alarm_config,     mod_reg_8_output_options,   mod_reg_9_enable_id,        mod_reg_9_command,          mod_reg_9_address,
            mod_reg_9_data_format,      mod_reg_9_alarm_config,     mod_reg_9_output_options,   mod_reg_10_enable_id,       mod_reg_10_command,
            mod_reg_10_address,         mod_reg_10_data_format,     mod_reg_10_alarm_config,    mod_reg_10_output_options,  mod_reg_11_enable_id,
            mod_reg_11_command,         mod_reg_11_address,         mod_reg_11_data_format,     mod_reg_11_alarm_config,    mod_reg_11_output_options,
            mod_reg_12_enable_id,       mod_reg_12_command,         mod_reg_12_address,         mod_reg_12_data_format,     mod_reg_12_alarm_config,
            mod_reg_12_output_options,  mod_reg_13_enable_id,       mod_reg_13_command,         mod_reg_13_address,         mod_reg_13_data_format,
            mod_reg_13_alarm_config,    mod_reg_13_output_options,  mod_reg_14_enable_id,       mod_reg_14_command,         mod_reg_14_address,
            mod_reg_14_data_format,     mod_reg_14_alarm_config,    mod_reg_14_output_options,  mod_reg_15_enable_id,       mod_reg_15_command,
            mod_reg_15_address,         mod_reg_15_data_format,     mod_reg_15_alarm_config,    mod_reg_15_output_options,  mod_reg_16_enable_id,
            mod_reg_16_command,         mod_reg_16_address,         mod_reg_16_data_format,     mod_reg_16_alarm_config,    mod_reg_16_output_options,
            mod_reg_17_enable_id,       mod_reg_17_command,         mod_reg_17_address,         mod_reg_17_data_format,     mod_reg_17_alarm_config,
            mod_reg_17_output_options,  mod_reg_18_enable_id,       mod_reg_18_command,         mod_reg_18_address,         mod_reg_18_data_format,
            mod_reg_18_alarm_config,    mod_reg_18_output_options,  mod_reg_19_enable_id,       mod_reg_19_command,         mod_reg_19_address,
            mod_reg_19_data_format,     mod_reg_19_alarm_config,    mod_reg_19_output_options,  mod_reg_20_enable_id,       mod_reg_20_command,
            mod_reg_20_address,         mod_reg_20_data_format,     mod_reg_20_alarm_config,    mod_reg_20_output_options,  mod_reg_21_enable_id,
            mod_reg_21_command,         mod_reg_21_address,         mod_reg_21_data_format,     mod_reg_21_alarm_config,    mod_reg_21_output_options,
            mod_reg_22_enable_id,       mod_reg_22_command,         mod_reg_22_address,         mod_reg_22_data_format,     mod_reg_22_alarm_config,
            mod_reg_22_output_options,  mod_reg_23_enable_id,       mod_reg_23_command,         mod_reg_23_address,         mod_reg_23_data_format,
            mod_reg_23_alarm_config,    mod_reg_23_output_options,  mod_reg_24_enable_id,       mod_reg_24_command,         mod_reg_24_address,
            mod_reg_24_data_format,     mod_reg_24_alarm_config,    mod_reg_24_output_options,  li_1_recog_time,            li_2_recog_time,
            li_3_recog_time,            li_4_recog_time,            li_5_recog_time,            li_6_recog_time,            li_7_recog_time,
            li_8_recog_time,            sm_no_reply_count,          sm_bad_reply_count,         mikrobus_1_no_reply_count,  mikrobus_1_bad_reply_count,
            mikrobus_2_no_reply_count,  mikrobus_2_bad_reply_count, mod_reg_1_no_reply_count,   mod_reg_1_bad_reply_count,  mod_reg_2_no_reply_count,
            mod_reg_2_bad_reply_count,  mod_reg_3_no_reply_count,   mod_reg_3_bad_reply_count,  mod_reg_4_no_reply_count,   mod_reg_4_bad_reply_count,
            mod_reg_5_no_reply_count,   mod_reg_5_bad_reply_count,  mod_reg_6_no_reply_count,   mod_reg_6_bad_reply_count,  mod_reg_7_no_reply_count,
            mod_reg_7_bad_reply_count,  mod_reg_8_no_reply_count,   mod_reg_8_bad_reply_count,  mod_reg_9_no_reply_count,   mod_reg_9_bad_reply_count,
            mod_reg_10_no_reply_count,  mod_reg_10_bad_reply_count, mod_reg_11_no_reply_count,  mod_reg_11_bad_reply_count, mod_reg_12_no_reply_count,
            mod_reg_12_bad_reply_count, mod_reg_13_no_reply_count,  mod_reg_13_bad_reply_count, mod_reg_14_no_reply_count,  mod_reg_14_bad_reply_count,
            mod_reg_15_no_reply_count,  mod_reg_15_bad_reply_count, mod_reg_16_no_reply_count,  mod_reg_16_bad_reply_count, mod_reg_17_no_reply_count,
            mod_reg_17_bad_reply_count, mod_reg_18_no_reply_count,  mod_reg_18_bad_reply_count, mod_reg_19_no_reply_count,  mod_reg_19_bad_reply_count,
            mod_reg_20_no_reply_count,  mod_reg_20_bad_reply_count, mod_reg_21_no_reply_count,  mod_reg_21_bad_reply_count, mod_reg_22_no_reply_count,
            mod_reg_22_bad_reply_count, mod_reg_23_no_reply_count,  mod_reg_23_bad_reply_count, mod_reg_24_no_reply_count,  mod_reg_24_bad_reply_count};

    public static int[] Modbus_2 =     {li_1_pulse_today,           li_1_pulse_yesterday,       li_1_pulse_this_month,      li_1_pulse_last_month,
            li_2_pulse_today,           li_2_pulse_yesterday,       li_2_pulse_this_month,      li_2_pulse_last_month,      li_3_pulse_today,
            li_3_pulse_yesterday,       li_3_pulse_this_month,      li_3_pulse_last_month,      li_4_pulse_today,           li_4_pulse_yesterday,
            li_4_pulse_this_month,      li_4_pulse_last_month,      li_5_pulse_today,           li_5_pulse_yesterday,       li_5_pulse_this_month,
            li_5_pulse_last_month,      li_6_pulse_today,           li_6_pulse_yesterday,       li_6_pulse_this_month,      li_6_pulse_last_month,
            li_7_pulse_today,           li_7_pulse_yesterday,       li_7_pulse_this_month,      li_7_pulse_last_month,      li_8_pulse_today,
            li_8_pulse_yesterday,       li_8_pulse_this_month,      li_8_pulse_last_month,};

    public static float[] Modbus_3 =   {li_1_pulse_mult,            li_2_pulse_mult,            li_3_pulse_mult,            li_4_pulse_mult,
            li_5_pulse_mult,            li_6_pulse_mult,            li_7_pulse_mult,            li_8_pulse_mult,            mod_reg_1_low,
            mod_reg_1_high,             mod_reg_1_calibration,      mod_reg_2_low,              mod_reg_2_high,             mod_reg_2_calibration,
            mod_reg_3_low,              mod_reg_3_high,             mod_reg_3_calibration,      mod_reg_4_low,              mod_reg_4_high,
            mod_reg_4_calibration,      mod_reg_5_low,              mod_reg_5_high,             mod_reg_5_calibration,      mod_reg_6_low,
            mod_reg_6_high,             mod_reg_6_calibration,      mod_reg_7_low,              mod_reg_7_high,             mod_reg_7_calibration,
            mod_reg_8_low,              mod_reg_8_high,             mod_reg_8_calibration,      mod_reg_9_low,              mod_reg_9_high,
            mod_reg_9_calibration,      mod_reg_10_low,             mod_reg_10_high,            mod_reg_10_calibration,     mod_reg_11_low,
            mod_reg_11_high,            mod_reg_11_calibration,     mod_reg_12_low,             mod_reg_12_high,            mod_reg_12_calibration,
            mod_reg_13_low,             mod_reg_13_high,            mod_reg_13_calibration,     mod_reg_14_low,             mod_reg_14_high,
            mod_reg_14_calibration,     mod_reg_15_low,             mod_reg_15_high,            mod_reg_15_calibration,     mod_reg_16_low,
            mod_reg_16_high,            mod_reg_16_calibration,     mod_reg_17_low,             mod_reg_17_high,            mod_reg_17_calibration,
            mod_reg_18_low,             mod_reg_18_high,            mod_reg_18_calibration,     mod_reg_19_low,             mod_reg_19_high,
            mod_reg_19_calibration,     mod_reg_20_low,             mod_reg_20_high,            mod_reg_20_calibration,     mod_reg_21_low,
            mod_reg_21_high,            mod_reg_21_calibration,     mod_reg_22_low,             mod_reg_22_high,            mod_reg_22_calibration,
            mod_reg_23_low,             mod_reg_23_high,            mod_reg_23_calibration,     mod_reg_24_low,             mod_reg_24_high,
            mod_reg_24_calibration};

    public static String[] Modbus_4 =  {li_1_uom,                   li_2_uom,                   li_3_uom,                   li_4_uom,
            li_5_uom,                   li_6_uom,                   li_7_uom,                   li_8_uom,                   mod_reg_1_uom,
            mod_reg_2_uom,              mod_reg_3_uom,              mod_reg_4_uom,              mod_reg_5_uom,              mod_reg_6_uom,
            mod_reg_7_uom,              mod_reg_8_uom,              mod_reg_9_uom,              mod_reg_10_uom,             mod_reg_11_uom,
            mod_reg_12_uom,             mod_reg_13_uom,             mod_reg_14_uom,             mod_reg_15_uom,             mod_reg_16_uom,
            mod_reg_17_uom,             mod_reg_18_uom,             mod_reg_19_uom,             mod_reg_20_uom,             mod_reg_21_uom,
            mod_reg_22_uom,             mod_reg_23_uom,             mod_reg_24_uom,             li_1_name,                  li_2_name,
            li_3_name,                  li_4_name,                  li_5_name,                  li_6_name,                  li_7_name,
            li_8_name,                  mod_reg_1_name,             mod_reg_2_name,             mod_reg_3_name,             mod_reg_4_name,
            mod_reg_5_name,             mod_reg_6_name,             mod_reg_7_name,             mod_reg_8_name,             mod_reg_9_name,
            mod_reg_10_name,            mod_reg_11_name,            mod_reg_12_name,            mod_reg_13_name,            mod_reg_14_name,
            mod_reg_15_name,            mod_reg_16_name,            mod_reg_17_name,            mod_reg_18_name,            mod_reg_19_name,
            mod_reg_20_name,            mod_reg_21_name,            mod_reg_22_name,            mod_reg_23_name,            mod_reg_24_name};

    public static final int[] Address_1 =      {10000,  10001,  10002,  10003,  10004,  10005,  10006,  10007,  10008,  10009,  10010,  10011,  10012,  10013,
                10014,  10015,  10016,  10017,  10018,  10019,  10020,  10021,  10022,  10025,  10026,  10027,  10028,  10029,  10030,  10031,  10032,  10033,
                10034,  10035,  10036,  10100,  10102,  10104,  10106,  10108,  10110,  10112,  10114,  10200,  10201,  10202,  10203,  10204,  10205,  10206,
                10207,  10208,  10209,  10210,  10211,  10212,  10213,  10214,  10215,  10216,  10217,  10218,  10219,  10220,  10221,  10222,  10223,  10224,
                10225,  10226,  10227,  10228,  10229,  10230,  10231,  10232,  10233,  10234,  10235,  10236,  10237,  10238,  10239,  10240,  10241,  10242,
                10243,  10244,  10245,  10246,  10247,  10248,  10249,  10250,  10251,  10252,  10253,  10254,  10255,  10256,  10257,  10258,  10259,  10260,
                10261,  10262,  10263,  10264,  10265,  10266,  10267,  10268,  10269,  10270,  10271,  10272,  10273,  10274,  10275,  10276,  10277,  10278,
                10279,  10280,  10281,  10282,  10283,  10284,  10285,  10286,  10287,  10288,  10289,  10290,  10291,  10292,  10293,  10294,  10295,  10296,
                10297,  10298,  10299,  10300,  10301,  10302,  10303,  10304,  10305,  10306,  10307,  10308,  10309,  10310,  10311,  10312,  10313,  10314,
                10315,  10316,  10317,  10318,  10319,  10320,  10321,  10322,  10323,  10324,  10325,  10326,  10327,  10328,  10329,  10330,  10331,  10332,
                10333,  10334,  10335,  10336,  10337,  10338,  10339,  10340,  10341,  10342,  10343,  12000,  12001,  12002,  12003,  12004,  12005,  12006,
                12007,  12100,  12101,  12102,  12103,  12104,  12105,  12106,  12107,  12108,  12109,  12110,  12111,  12112,  12113,  12114,  12115,  12116,
                12117,  12118,  12119,  12120,  12121,  12122,  12123,  12124,  12125,  12126,  12127,  12128,  12129,  12130,  12131,  12132,  12133,  12134,
                12135,  12136,  12137,  12138,  12139,  12140,  12141,  12142,  12143,  12144,  12145,  12146,  12147,  12148,  12149,  12150,  12151,  12152,
                12153};

    public static final int[] Address_2 =      {13000,  13001,  13002,  13003,  13004,  13005,  13006,  13007,  13008,  13009,  13010,  13011,  13012,  13013,
                13014,  13015,  13016,  13017,  13018,  13019,  13020,  13021,  13022,  13023,  13024,  13025,  13026,  13027,  13028,  13029,  13030,  13031};

    public static final int[] Address_3 =      {14000,  14001,  14002,  14003,  14004,  14005,  14006,  14007,  14100,  14101,  14102,  14105,  14106,  14107,
                14110,  14111,  14112,  14115,  14116,  14117,  14120,  14121,  14122,  14125,  14126,  14127,  14130,  14131,  14132,  14135,  14136,  14137,
                14140,  14141,  14142,  14145,  14146,  14147,  14150,  14151,  14152,  14155,  14156,  14157,  14160,  14161,  14162,  14165,  14166,  14167,
                14170,  14171,  14172,  14175,  14176,  14177,  14180,  14181,  14182,  14185,  14186,  14187,  14190,  14191,  14192,  14195,  14196,  14197,
                14200,  14201,  14202,  14205,  14206,  14207,  14210,  14211,  14212,  14215,  14216,  14217};

    public static final int[] Address_4 =      {15600,  15601,  15602,  15603,  15604,  15605,  15606,  15607,  15608,  15609,  15610,  15611,  15612,  15613,
                15614,  15615,  15616,  15617,  15618,  15619,  15620,  15621,  15622,  15623,  15624,  15625,  15626,  15627,  15628,  15629,  15630,  15631,
                16000,  16001,  16002,  16003,  16004,  16005,  16006,  16007,  16008,  16009,  16010,  16011,  16012,  16013,  16014,  16015,  16016,  16017,
                16018,  16019,  16020,  16021,  16022,  16023,  16024,  16025,  16026,  16027,  16028,  16029,  16030,  16031};
}
