<template>
  <div>

    <div class="top_text">
      Видео поток из склада
    </div>
    <div>
      <!--src="https://www.youtube.com/embed/XqaiNe-W03k?autoplay=1&controls=0&disablekb=1&enablejsapi=1&playsinline=1&color=white&modestbranding=1&;showinfo=0&;autohide=1&;rel=0;"-->
      <iframe style="display: block;margin: 0 auto;border-radius: 10px;overflow: hidden;"
              id="ytplayer" type="text/html" width="720" height="405"
              src="https://www.youtube.com/embed/7NOSDKb0HlU?autoplay=1&controls=0&disablekb=1&enablejsapi=1&playsinline=1&color=white&modestbranding=1&showinfo=0&autohide=1&rel=0"
              frameborder="0" allowfullscreen> </iframe>

      <button @click="renew" title="Обновить" class="button_3">Обновить
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "broadcast",
  methods: {
    renew: function () {
      window.location.reload();
    },
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap%27');

.how {
  background: #F6FBFF;
  display: block;
  width: 80%;
  margin: 0 auto;
}

.top_text{
  font-size: 30px;
  line-height: 36px;
  color: #000000;
  text-align: center;
  margin-bottom:3%;
  margin-top:3%;

}

.video__link{   /*ширину и высоту указывать только в линке*/
  display: block;
  margin: 0 auto;
}

.button_3 {
  outline: none;
  background-color: Transparent;
  background-repeat: no-repeat;
  border: none;
  cursor: pointer;
  overflow: hidden;
  margin-bottom: 5%;
  margin-top: 1%;

  font-size: 25px;
  text-decoration-line: underline;
  text-transform: uppercase;
  color: #000000;

  position: relative;
  left: 45%;
}

</style>