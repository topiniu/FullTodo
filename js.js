var root = new Vue({
  el: '#root',
  data() {
    return {
      msg: 'pp',
      everyListHeight: [],
      everyListScrollTop: [],
      itemList: [],
    }
  },
  created() {
    const self = this;

    var s = $('.j_date-list-container');
    var totalHeight = 0;
    for (var i = 0; i < s.length; i++) {
      self.everyListHeight[i] = s.height();
      totalHeight += s.height();
    }
    var f = 0;
    self.everyListScrollTop[0] = 0;
    self.everyListScrollTop[1] = self.everyListHeight[1];
    for (var p = 2; p < self.everyListHeight.length; p++) {
      self.everyListScrollTop[p] = self.everyListHeight[p - 1] + self.everyListScrollTop[p - 1];
    }
    var topIndex = -1;
    $(window).on('scroll', function () {
      if ($(window).scrollTop() === 0) {
        $('.j_date-block').removeClass('fixed-top');
        topIndex = -1;
      }
      for (var i = 0; i < self.everyListHeight.length - 1; i++) {
        if (i !== topIndex && $(window).scrollTop() < self.everyListScrollTop[i + 1] && $(window).scrollTop() > self.everyListScrollTop[i]) {
          $('.j_date-block').removeClass('fixed-top');
          $('.j_date-list-container').eq(i).find('.j_date-block').addClass('fixed-top');
          topIndex = i;
        }
      }
    });
  }
})