/**
 *
 */

// import * as appConfig from '../config/appConfig.js';

// export function buildUrl(api_url) {
//   const url = appConfig.account_service_host + api_url;
//   // let url = [appConfig.account_service_host, api_url].join('/')
//   console.debug(url);
//   return url;
// }

// const errTypeLfShift = 20;
// export class ResponseErrorInfo {
//   constructor(code, msg) {
//     this.errType = code >>> errTypeLfShift;
//     this.errValue = code ^ (this.errType << errTypeLfShift);
//     this.msg = msg;
//   }
// }

// export function serverErrorProc(err_resp) {
//   console.error(err_resp);
// }

// export function httpErrorProc(err_resp) {
//   console.error(err_resp);
// }

// const resp_code_key = 'code';
// const resp_data_key = 'data';
// const resp_errmsg_key = 'errMsg';

// export function response_process(resp, success_cb, fail_cb = serverErrorProc) {
//   const resp_data = resp.data;

//   if (!(resp_code_key in resp_data)) {
//     success_cb(resp_data);
//     return;
//   }

//   const code = resp_data[resp_code_key];
//   if (code == 0) {
//     const data = resp_data[resp_data_key];
//     success_cb(data);
//     return;
//   }

//   const errmsg = resp_data[resp_errmsg_key];
//   const err = new ResponseErrorInfo(code, errmsg);
//   fail_cb(err);
// }
