<template>
  <div class="callback">
    <div class="callback__text">
      <br>
      <h1>
        Готовы работать с нами?
      </h1>
      <h3>
        Если мы вас убедили или у вас остались какие-либо вопросы оставьте нам свои контакты, мы с вами свяжемся и проконсультируем по всем вопросам.
        <br>
        <input type="tel" placeholder="8(999)999-99-99" title="номер" class="input__more">
        <button @click="" title="Кнопка для входа в существующий аккаунт" class="btn__more">
          Отправить
        </button>
      </h3>
      <br>
      <br>
      <br>
    </div>

  </div>
</template>

<script>
export default {
  name: "callback"
}
</script>

<style scoped>


h1,h2,h3,input,button {

  margin: 10px;
}

.callback {
  margin-top: 50px;
  width:100%;
  height:100%;
}

.callback__text{
  border: 15px;
  display: table;
  margin: 0 auto;
  background: #F6FBFF;;
  width: 40%;
  height: 50%;
  top: 25%;

}

.input__more {
  font-size: 22px;
  text-align: center;
  background: white;
  border: 2px solid dodgerblue;
  box-sizing: border-box;
  border-radius: 30px;
  color: black;
  transition: all 500ms ease;
  outline: 0 none !important;
}

.btn__more {
  font-size: 22px;
  text-align: center;
  background: dodgerblue;
  border: 2px solid dodgerblue;
  box-sizing: border-box;
  border-radius: 30px;
  color: white;
  transition: all 500ms ease;
  outline: 0 none !important;
}
</style>