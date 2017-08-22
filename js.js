var root = new Vue({
  el: '#root',
  data() {
    return {
      msg: 'pp',
      everyListHeight: [],
      everyListScrollTop: []
    }
  },
  created() {
    const self = this;
    console.log('hhh');
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
      self.everyListScrollTop[p] = self.everyListHeight[i - 1] + self.everyListHeight[i - 2];
    }

    var topIndex = -1;
    $(window).on('scroll', function () {
      for (var i = 0; i < self.everyListHeight.length - 1; i++) {
        console.log(self.everyListScrollTop[i + 1] + "--" + self.everyListScrollTop[i]);
        if (i !== topIndex && $(window).scrollTop() < self.everyListScrollTop[i + 1] && $(window).scrollTop() > self.everyListScrollTop[i]) {
          // $('.j_date-list-container').eq(1).css('padding-top', '0');
          $('.j_date-block').removeClass('fixed-top');

          // $('.j_date-list-container').eq(i).css('padding-top', '34px');
          $('.j_date-list-container').eq(i).find('.j_date-block').addClass('fixed-top')
          console.log('pp');
          topIndex = i;
        }
      }
    });
  }
})