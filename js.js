var root = new Vue({
  el: '#root',
  data() {
    return {
      msg: 'pp',
      everyListHeight: [],
      everyListScrollTop: [],
      items: {},
      itemList: [],

      showAddPanel:false,
    }
  },
  methods:{
    del(item){
      item.isFinished = true;
    },
    addItem(){
      const self = this;
      self.items.push({
        content: self.content,
        date: new Date().getFullYear + '-' + new Date().getMonth + '-' + new Date().getDay(),
        isFinished: false,
      });
      this.showAddPanel = false;
    },
  },
  created() {
    const self = this;
    
    $.ajax({
      url: 'testdata.json',
      data: '',
      dataType: 'JSON',
      type:'GET',
      success: function(data){
        self.items = JSON.parse(data);
      },
      error:function(err){
        alert('Something wrong 哈哈哈哈');
      }
    })
  },
  updated(){
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
      for (var i = 0; i < self.everyListHeight.length; i++) {
        
        if ((i !== topIndex && $(window).scrollTop() < self.everyListScrollTop[i + 1] && $(window).scrollTop() > self.everyListScrollTop[i])) {
          $('.j_date-block').removeClass('fixed-top');
          $('.j_date-list-container').eq(i).find('.j_date-block').addClass('fixed-top');
          topIndex = i;
        }else if($(window).scrollTop() > self.everyListScrollTop[self.everyListScrollTop.length-1]){
          $('.j_date-block').removeClass('fixed-top');
          $('.j_date-list-container').eq(self.everyListScrollTop.length-1).find('.j_date-block').addClass('fixed-top');
          topIndex = self.everyListScrollTop.length-1;
        }
      }
    });

  }
})