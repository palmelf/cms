<#include "header.ftl">
     <!-- revolution slider start -->
     <div class="fullwidthbanner-container main-slider">
         <div class="fullwidthabnner">
             <ul id="revolutionul" style="display:none;">
                 <!-- 1st slide -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                 	<img src="${TEMPLATE_PATH}/img/banner/1.jpg" alt="">
                     <div class="caption lfl slide_item_left"
                          data-x="10"
                          data-y="70"
                          data-speed="500"
                          data-start="1500"
                          data-easing="easeOutBack">
                         <img src="${TEMPLATE_PATH}/img/banner/ban2.png" alt="Image 1">  
                     </div>
                     <div class="caption lfr slide_subtitle dark-text"
                          data-x="670"
                          data-y="190"
                          data-speed="500"
                          data-start="2000"
                          data-easing="easeOutExpo">
                         智慧交通项目，盗无忧
                     </div>
                     <div class="caption lfr slide_desc"
                          data-x="670"
                          data-y="420"
                          data-speed="500"
                          data-start="2500"
                          data-easing="easeOutExpo">
                        采用最先进的技术构建区域级智慧交通信息与管理平台<br>
                        基于行车安全、出行路况采集、交通信息发布与管理
                     </div>

                 </li>

                 <!-- 2nd slide  -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     <!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
                     <img src="${TEMPLATE_PATH}/img/banner/2c.jpg" alt="">
                        <div class="caption lfl slide_item_left" style="margin-top:10%"
                          data-x="10"
                          data-y="70"
                          data-speed="500"
                          data-start="1500"
                          data-easing="easeOutBack">
                         <img src="${TEMPLATE_PATH}/img/banner/2b.png" alt="Image 1">  
                     </div>
                     <div class="caption lft start" style="margin-left:-10%"
                          data-x="640"
                          data-y="55"
                          data-speed="500"
                          data-start="2000"
                          data-easing="easeOutBack"  >
                         <img src="${TEMPLATE_PATH}/img/banner/2a.png" alt="man">
                     </div>
                     <div class="caption lft slide_item_right"
                          data-x="330"
                          data-y="20"
                          data-speed="500"
                          data-start="5000"
                          data-easing="easeOutBack">
                         <img src="${TEMPLATE_PATH}/img/banner/test_man.png" id="rev-hint2" alt="txt img">
                     </div>
                 </li>
                 
                            <!-- 3nd slide  -->
                   <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     <!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
                     <img src="${TEMPLATE_PATH}/img/banner/3a.jpg" alt="">
                        <div class="caption lfl slide_item_left" style="margin-top:5%; margin-left:32%"
                          data-x="10"
                          data-y="70"
                          data-speed="500"
                          data-start="1500"
                          data-easing="easeOutBack">
                         <img src="${TEMPLATE_PATH}/img/banner/3b.png" alt="Image 1">  
                     </div>
                 </li>

             </ul>
            <div class="tp-bannertimer tp-top"></div>
         </div>
     </div>
     <!-- revolution slider end -->
   <script>
  $(function(){
      RevSlide.initRevolutionSlider();
      $(window).load(function() {
          $('[data-zlname = reverse-effect]').mateHover({
              position: 'y-reverse',
              overlayStyle: 'rolling',
              overlayBg: '#fff',
              overlayOpacity: 0.7,
              overlayEasing: 'easeOutCirc',
              rollingPosition: 'top',
              popupEasing: 'easeOutBack',
              popup2Easing: 'easeOutBack'
          });
      });
      $(window).load(function() {
          $('.flexslider').flexslider({
              animation: "slide",
              start: function(slider) {
                  $('body').removeClass('loading');
              }
          });
      });

      //    fancybox
      jQuery(".fancybox").fancybox();  	
  });
  </script>     
     <#include "footer.ftl">