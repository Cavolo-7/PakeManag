<%--
  Created by IntelliJ IDEA.
  User: 69080
  Date: 2020/9/11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
  <title>
    迪士尼        - 智慧停车|骑着文伟撞传奇    </title>
  <meta name="Keywords" content="捷停车,智慧停车,找车位,租车位,云托管服务,停车,">
  <meta name="Description" content="捷停车（JParking），是顺易通推出的智慧停车一体化服务平台，主要业务包括智慧停车车场运营服务、通道运营服务、广告运营服务三大版块。">

  <link rel="stylesheet" href="../resources/css/bootstrap.min.css">

  <script src="../resources/js/jquery.min.js"></script>
  <script name="baidu-koubei-verification" src="../resources/js/f0b9ab914a11485abbfd99ac8230b987.js"></script>
  <script src="../resources/js/bootstrap.min.js"></script>
<%--  <link rel="shortcut icon" href="http://www.jparking.cn/static/company/assets/image/LOGO.png">--%>
<%--  <link rel="Bookmark" href="http://www.jparking.cn/static/company/assets/image/LOGO.png">--%>
  <link rel="stylesheet" href="../resources/css/animate.css">
  <link rel="stylesheet" href="../resources/css/bootstrap.min_1.css">
  <link rel="stylesheet" href="../resources/css/owl.carousel.min.css">
  <link rel="stylesheet" href="../resources/css/slicknav.css">
  <link rel="stylesheet" href="../resources/css/style.css">
  <link rel="stylesheet" href="../resources/css/responsive.css">
  <script type="text/javascript" src="../resources/js/jquery-1.12.4.min.js"></script>
  <style>
    .bannerBox {
      position: relative;
    }


    .bannerBottom {
      position: absolute;
      bottom: 0;
      left: 0;
      width: 100%;
    }

    .newsBox {
      background: url(../resources/images/newsbac.png) #fff no-repeat center bottom;
      background-size: contain
    }

    .newsBox .title p {
      line-height: 174px;
      text-align: center;
      color: #333;
      background: url(../resources/images/newstitlebac.png) no-repeat center 24px;

    }

    @media only screen and (max-width: 767px) {
      .dataCount{
        margin-top:50px;
      }
      .pd-130{
        padding:0;
      }
      #gotop{
        z-index: 9999;
        /*display: none;*/
      }
      .newsBox .title p {
        background-size: contain;
      }
      .bannerBox .bacimg {
        /*min-height: 245px;*/
        max-width: 100%;
      }

      .bannerBox {
        position: relative;
        top:68px;
      }
      .single-counter-box{
        margin-bottom:60px;
      }
      .newsContent .mainNews i{
        text-align:right;
      }
      .fadeInLeft{
        margin-bottom:-50px;
      }

    }



    .newsBox .title p i {
      font-style: normal;
      color: #1375ed;
    }

    .newsBox .mainNews img {
      max-width: 100%;
      margin-top: 24px;
      margin-bottom: 20px;
    }

    .newsBox .secNews .list {
      position: relative;
    }

    .newsContent strong {
      font-size: 18px;
      color: #333333;
      margin-bottom: 20px;
      display: block;
    }

    .newsContent .mainNews i {
      display: block;
      font-style: normal;
      color: #4f4f4f;
      font-size: 18px;
      margin-bottom: 22px;
    }

    .newsContent .secNews i {
      display: block;
      font-style: normal;
      color: #4f4f4f;
      font-size: 14px;
      margin-bottom: 22px;
      text-align: right;
    }

    .newsContent p {
      color: #4f4f4f;
      line-height: 28px;
    }

    .dataCount {

      width: 100%;
      background: url(../resources/images/data-bac.jpg);
      padding: 48px 0;
    }

    .dataCount .list p {
      line-height: 24px;
      color: #333;
      font-size: 16px;
    }

    .dataCount .row {
      width: 100%;
      max-width: 1200px;
      margin: 0 auto;
    }

    .dataCount .counter-number {
      line-height: 92px;
      color: #0382db;
    }

    .dataCount .list span i {
      color: #666666;
      font-size: 50px;
      font-style: normal;
    }

    #footerHtml {
      background: url(../resources/images/footerbac.jpg) no-repeat center;
      background-size: cover;
      padding-top: 35px;
    }

    #footerHtml p,
    #footerHtml li,
    #footerHtml p a {
      margin-bottom: 16px;
      font-size: 14px;
      color: #fff;
    }

    #footerHtml li a {
      font-size: 14px;
      color: #fff;
      margin-right: 30px;
    }

    #footerHtml input,
    textarea {
      background: none;
      border: 1px solid #166498;
      padding: 10px 16px;
      margin-bottom: 15px;
      border-radius: 5px;
      width: 100%;
    }

    .input-group,
    #footerHtml textarea {
      width: 100%;
    }

    #footerHtml .btn-submit {
      font-size: 16px;
      color: #fff;
      width: 164px;
      float: left;
    }

    .footerBottom {
      margin-top: 60px;
      padding-bottom: 20px;
    }

    @media screen and (min-width: 990px) {
      .newsBox .mainNews {
        padding-right: 0px;
      }

      .newsBox .secNews .point {
        position: absolute;
        display: block;
      }

      /*.newsBox .secNews .noActive {*/
      /*  height: 12px;*/
      /*  width: 12px;*/
      /*  background: url(../state/images/newsactive.png) no-repeat center left;*/
      /*  left: -48px;*/
      /*  top: 7px;*/
      /*}*/
      /*.newsBox .secNews .active {*/
      /*  height: 62px;*/
      /*  width: 62px;*/
      /*  background: url(../state/images/newsactive.png) #fff no-repeat center left;*/
      /*  left: -75px;*/
      /*  top: -18px;*/
      /*}*/

      .newsBox .secNews {
        border-left: 1px solid #ccc;
        padding-left: 42px;
      }

    }
  </style>

</head>
<input type="hidden" name="tid" value="">
<input type="hidden" name="cid" value="0"><style>
  #contact-form textarea,#contact-form input{color: #fff}
  .secNews .probootstrap-animate:hover strong,.secNews .probootstrap-animate:hover p,.secNews .probootstrap-animate:hover i{
    color: #0099ff;
    cursor: pointer;
  }
  .mainNews:hover strong,.mainNews:hover p,.mainNews:hover i{
    color: #0099ff;
    cursor: pointer;
  }
  #footerHtml li a{
    margin:0 20px;
  }
  #footerHtml li, #footerHtml li a,#footerHtml p, #footerHtml p a{color:#9fa1ad;}
  @media screen and (max-width: 640px){
    #footerHtml li a{
      font-size:12px;margin:0 15px;}
  }
</style>

<body>
<script src="../resources/js/layer.js"></script>
<link rel="stylesheet" href="../resources/css/swiper-3.4.2.min.css">
<script src="../resources/js/swiper-3.4.2.jquery.min.js"></script>
<style>

</style>
<div id="mainmenu-area">
  <div class="header-area header-absolute">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-3 w-50 display_flex align-center">
          <a href="http://www.jparking.cn/home" class="header-logo">
            <img src="../resources/picture/5dc9268f39e0e.png" alt="">
          </a>
        </div>
        <div class="col-lg-8 col-md-8 w-50 t-right display_flex">
          <button class="toggle">
            <span></span>
          </button>
          <div class="mainmenu">
            <nav>
              <ul>
                <li class="active"><a href="${pageContext.request.contextPath}/jsp/main.jsp">首页</a></li>
                <li >
                  <a  href="${pageContext.request.contextPath}/jsp/UserLogin.jsp">客户端</a>
                </li>
                <li >
                  <a href="${pageContext.request.contextPath}/jsp/Login.jsp">管理端</a>
                </li>
                <li >
                  <a  href="/car//noCarWelcome">扫描系统</a>
                </li>
                <li >
                  <a  href="http://www.jparking.cn/lists/index?tid=4">关于我们</a>
                </li>
                <script>
                  if(screen.width >375){

                    $(".aaad a").removeAttr('style');
                  }
                </script>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>

  //轮播图
</script><div class="hero-area">
  <div class="bannerBox">
    <div class="swiper-container index-banner">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
<%--          <a href="https://www.jslife.com.cn/info-collection/parkRental.html?busType=5&orderSource=1#/" target="_blank">--%>
            <img src="../resources/picture/20030505432524886.jpg" class="wow fadeIn bacimg" />
          </a>
        </div>
        <div class="swiper-slide">
<%--          <a href="https://www.jslife.com.cn/info-collection/no-sense-payment-coll.html?busType=6&orderSource=1#/" target="_blank">--%>
            <img src="../resources/picture/20030505411114915.jpg" class="wow fadeIn bacimg" />
          </a>
        </div>
        <div class="swiper-slide">
<%--          <a href="https://www.jslife.com.cn/info-collection/monthly-card.html?busType=7&orderSource=1#/" target="_blank">--%>
            <img src="../resources/picture/20030505342174169.jpg" class="wow fadeIn bacimg" />
          </a>
        </div>
        <div class="swiper-slide">
<%--          <a href="https://www.jslife.com.cn/info-collection/electronic-invoice.html?busType=3&orderSource=1#/" target="_blank">--%>
            <img src="../resources/picture/20030505334627771.jpg" class="wow fadeIn bacimg" />
          </a>
        </div>
        <div class="swiper-slide">
<%--          <a href="https://www.jslife.com.cn/info-collection/collection.html?busType=1&orderSource=1&view=locationNine#/" target="_blank">--%>
            <img src="../resources/picture/20032002544193178.png" class="wow fadeIn bacimg" />
          </a>
        </div>
      </div>
      <!-- Add Arrows -->
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper('.index-banner', {
        pagination: '.swiper-pagination',
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        slidesPerView: 1,
        paginationClickable: true,
        spaceBetween: 1,
        centeredSlides: true,
        autoplay: 3000,
        autoplayDisableOnInteraction: false,
        loop: true
      });
    </script>
    <div class="banner_down">
      <ul>
        <li>
          <div class="ban1" >
            <h3>车场端</h3>
            <span >降本、提效、增收</span>
          </div>
        </li>
        <li>
          <div class="ban2" >
            <h3>商户端</h3>
            <span>精准营销服务</span>
          </div>
        </li>
        <li>
          <div class="ban3" >
            <h3>车主端</h3>
            <span>便捷、优惠车生活</span>
          </div>
        </li>
        <li>
          <div class="ban4">
            <h3>政府端</h3>
            <span>解决停车难题惠及民生</span>
          </div>
        </li>
        <li>
          <div class="ban5">
            <h3>生态端</h3>
            <span>开放赋能共筑停车生态</span>
          </div>
        </li>
      </ul>
    </div>
  </div>

  <div class="dataCount">
    <div class="container">
      <div class="row">
        <div class="col-lg-2 col-md-6 wow fadeInLeft" data-wow-delay="0.8s">
          <div class="single-counter-box">
            <p class="counter-number fs68"><span>279</span>+</p>
            <p>覆盖城市</p>
            <!-- <p>COVERING CITIES</p>-->
          </div>
        </div>
        <div class="col-lg-3 col-md-6 wow fadeInLeft" data-wow-delay="0.6s">
          <div class="single-counter-box">
            <p class="counter-number fs68"><span>13600</span>+</p>
            <p>智慧停车场</p>
            <!-- <p>SMART PARKING</p>-->
          </div>
        </div>
        <div class="col-lg-3 col-md-6 wow fadeInLeft" data-wow-delay="0.4s">
          <div class="single-counter-box">
            <p class="counter-number fs68"><span>540</span>w+</p>
            <p>停车位</p>
            <!-- <p>PAPKING SPACE</p>-->
          </div>
        </div>
        <div class="col-lg-3 col-md-6 wow fadeInLeft" data-wow-delay="0.2s">
          <div class="single-counter-box">
            <p class="counter-number fs68"><span>2300</span>w+</p>
            <p>累计用户数</p>
            <!-- <p>CUMULATIVE USERS</p>-->
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="rectangle-area pd-130 o-hi newsBox">
  <div class="container newsContent">
    <div class="title probootstrap-animate">
      <p class="fs48">企业<i>动态</i></p>
    </div>
    <div class="row aic">
      <div class="col-lg-5  wow fadeInLeft" data-wow-delay="0.2s">
        <div class="mainNews" style="margin:0 10px;">
          <a href="http://www.jparking.cn/lists/detail?tid=5&cid=8&id=88">
            <img src="resources/picture/5ee2e0e11f763.png" style="width:100%;height:100%;"/>
            <strong>城市停车场“新基建”驶入快车道，停车场云托管管理模式正当风口</strong>
            <p>当下的智慧停车行业在全国各地区、各领域都呈现出活跃的发展态势，政策、市场、技术齐头并进，不管是城市智慧化发展和市场供需关系的客观要求，还是疫情带来的停车场景变革影响，智慧停车行业的发展备受大众关注。</p>
            <i class="text-right" style="font-size:14px; border-bottom: 1px dashed #999; padding-bottom: 6px; margin-bottom: 72px;">2020-06-12</i>
          </a>
        </div>
      </div>
      <div class="col-lg-6 wow fadeInRight" data-wow-delay="0.4s">
        <div class="secNews ">
          <a href="http://www.jparking.cn/lists/detail?tid=5&cid=8&id=86">
            <div class="list probootstrap-animate ">
              <span class="point noActive"></span>
              <strong>通达莞邑便利生活：捷停车受邀出席东莞通APP新功能发布会</strong>
              <p>6月3日上午，东莞通公司在东莞市市民中心展开了“东莞通APP便民新功能上线发布仪式”，捷顺东莞分公司以及捷顺旗下智慧停车一体化服务平台捷停车受邀参与。</p>
              <i style="border-bottom: 1px dashed #999; padding-bottom: 6px; margin-bottom: 16px;">2020-06-03</i>
            </div>
          </a>

          <a href="http://www.jparking.cn/lists/detail?tid=5&cid=8&id=82">
            <div class="list probootstrap-animate">
              <span class="point noActive"></span>
              <strong>捷停车总用户数突破1500万！“疫考”之下，智慧停车见真章</strong>
              <p>5月14日，捷停车累计用户达到15,014,196名，总用户数突破1500万，距离突破1000万的2019年12月仅过去不足5个月，中间还经历了春节假期和新冠疫情全国严抓防控的时期。</p>
              <i>2020-05-15</i>
            </div>
          </a>
        </div>
        <div style="clear: both;"></div>
      </div>
    </div>


  </div>
  <script>
    $(function () {

      //企业动态
      $('.secNews .probootstrap-animate').mouseover(function () {

        $(this).find('.point').addClass('active').removeClass('noActive')
      }).mouseleave(function () {

        $(this).find('.point').addClass('noActive').removeClass('active')
      })
    })
  </script>

</div>

<div id="footerHtml">
  <div class="container">

    <style>
      .contact-index-p img{cursor: pointer}
    </style>
    <script>
      $(function () {
        $('.contact-index-p img').mouseover(function () {

          var url = $(this).attr('src');
          var front = url.substr(0, url.indexOf(url.substr(-6,6)));
          $(this).attr('src', front+ '.png');

          $(this).next().css("display","block");

        }).mouseout(function () {

          var url = $(this).attr('src');
          var front = url.substr(0, url.indexOf(url.substr(-4,4)));
          $(this).attr('src', front+ '_s.png');

          $(this).next().css("display","none");
        })
      })
    </script>
    <style>
      .col-lg-6 h1 {
        font-size: 28px;
        color: #00a0d9;
        line-height: 36px;
        font-weight: normal;
      }
    </style>
    <div class="row">
      <div class="col-lg-6">
        <p class="cos">24小时咨询热线</p>
        <h1>400-700-5305</h1>
        <p>地址：厦门软件园二期25号之二</p>
        <div class="contact-index-p" style="position:relative;">
          <p style="display: inline-block">联系我们：</p>&nbsp;&nbsp;
          <img src="resources/picture/wx_s.png" alt="">&nbsp;&nbsp;
          <div style="position:absolute;left: 40px;top: -110px;padding: 5px;border: 1px solid #fff;background: #fff;display: none">
            <img src="resources/picture/5e85a528ced43.png" alt="">
          </div>
          <img src="resources/picture/zfb_s.png" alt="">&nbsp;&nbsp;
          <div style="position:absolute;left: 75px;top: -110px;padding: 5px;border: 1px solid #fff;background: #fff;display: none">
            <img src="resources/picture/5e85a528cfc86.png" alt="">
          </div>
          <img src="resources/picture/wb_s.png" alt="">&nbsp;&nbsp;
          <div style="position:absolute;left: 110px;top: -110px;padding: 5px;border: 1px solid #fff;background: #fff;display: none">
            <img src="resources/picture/5e85a528d0056.png" alt="">
          </div>
        </div>
        <p>商务合作：0755-83112288-8189</p>
        <p>邮箱：jtc@jparking.cn</p>
      </div>
    <ul class="display_flex" style="flex-wrap:wrap;">
      <li>友情链接：</li>
      <li style="width:85px;">
        <a style="margin:0;" href="https://www.jieshun.cn/" target="_blank">
          捷顺科技                        </a>
      </li>

      <li style="width:85px;">
        <a style="margin:0;" href="https://www.antfin.com/" target="_blank">
          蚂蚁金服                        </a>
      </li>

      <li style="width:85px;">
        <a style="margin:0;" href="http://www.jsfintech.cn/" target="_blank">
          捷顺金科                        </a>
      </li>

      <li style="width:85px;">
        <a style="margin:0;" href="http://www.jieyisoft.com/" target="_blank">
          捷弈软件                        </a>
      </li>

      <li style="width:85px;">
        <a style="margin:0;" href="http://www.sztqjf.com/" target="_blank">
          特区建发集团                        </a>
      </li>

    </ul>
  </div>
</div>
<script src="../resources/js/jquery-1.12.4.min.js"></script>
<script src="../resources/js/popper.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/owl.carousel.min.js"></script><!-- 页面动画 -->
<script src="../resources/js/jquery.counterup.min.js"></script>
<script src="../resources/js/waypoints.min.js"></script>
<script src="../resources/js/jquery.sticky.js"></script>
<script src="../resources/js/wow.min.js"></script>
<script src="../resources/js/slicknav-min.js"></script>
<script src="../resources/js/main.js"></script>
</body>
</html>