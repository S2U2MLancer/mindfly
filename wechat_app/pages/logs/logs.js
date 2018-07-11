// logs.js
const util = require('../../utils/utils.js');

Page({
  data: {
    logs: []
  },
  onLoad() {
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(log => util.formatTime(new Date(log)))
    });
  }
});
