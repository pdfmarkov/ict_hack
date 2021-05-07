<template>
  <header class="header">
    <div class="container">
      <div class="header__inner">
        <div class="header__logo">
          <svg width="67" height="59" viewBox="0 0 67 59" fill="none" xmlns="http://www.w3.org/2000/svg" @click="goTo('main')">
            <path d="M32.1729 0.405522L1.00493 22.3047C0.736584 22.4933 0.50982 22.7394 0.33977 23.0267C0.16972 23.3141 0.0602957 23.636 0.0187992 23.971C-0.0226973 24.306 0.00468849 24.6465 0.0991293 24.9695C0.19357 25.2926 0.352894 25.591 0.566467 25.8446L3.13778 28.9032C3.50219 29.3356 4.00457 29.6148 4.55141 29.6891C5.09825 29.7634 5.65229 29.6275 6.11041 29.3069L32.1729 11.0097C32.5476 10.747 32.9887 10.6068 33.4399 10.6068C33.8912 10.6068 34.3323 10.747 34.707 11.0097L60.7769 29.2991C61.235 29.6198 61.7891 29.7556 62.3359 29.6813C62.8828 29.6071 63.3851 29.3278 63.7495 28.8955L66.3209 25.8369C66.5344 25.5832 66.6938 25.2849 66.7882 24.9618C66.8826 24.6387 66.91 24.2983 66.8685 23.9633C66.827 23.6282 66.7176 23.3063 66.5476 23.019C66.3775 22.7316 66.1507 22.4855 65.8824 22.297L34.7145 0.405522C34.339 0.141204 33.8965 0 33.4437 0C32.9909 0 32.5484 0.141204 32.1729 0.405522Z" fill="#FF7A22"/>
            <path d="M56.4231 30.0908L34.7155 14.7513C34.3393 14.4853 33.8954 14.3431 33.441 14.3431C32.9867 14.3431 32.5428 14.4853 32.1665 14.7513L10.4664 30.0908C10.1583 30.3077 9.90578 30.6001 9.73088 30.9425C9.55599 31.2849 9.46406 31.6668 9.46313 32.0549V56.6323C9.46411 56.9442 9.52389 57.2529 9.63908 57.5407C9.75426 57.8286 9.92259 58.0899 10.1344 58.3097C10.3463 58.5296 10.5975 58.7037 10.8738 58.8221C11.1501 58.9406 11.446 59.001 11.7446 59H18.054V39.9963C18.054 39.7101 18.1628 39.4357 18.3566 39.2333C18.5503 39.031 18.813 38.9173 19.087 38.9173H26.5185C26.7925 38.9173 27.0553 39.031 27.249 39.2333C27.4427 39.4357 27.5515 39.7101 27.5515 39.9963V59H55.1449C55.748 59 56.3264 58.7497 56.7529 58.3042C57.1793 57.8587 57.4189 57.2545 57.4189 56.6245V32.0549C57.4188 31.6675 57.328 31.286 57.1545 30.9437C56.9809 30.6014 56.7298 30.3086 56.4231 30.0908ZM49.326 46.0436C49.326 46.2495 49.2477 46.447 49.1083 46.5926C48.9689 46.7382 48.7799 46.8199 48.5828 46.8199H40.5493C40.3522 46.8199 40.1632 46.7382 40.0238 46.5926C39.8844 46.447 39.8062 46.2495 39.8062 46.0436V38.8707C39.8062 38.6648 39.8844 38.4674 40.0238 38.3218C40.1632 38.1762 40.3522 38.0944 40.5493 38.0944H48.5902C48.7873 38.0944 48.9764 38.1762 49.1157 38.3218C49.2551 38.4674 49.3334 38.6648 49.3334 38.8707L49.326 46.0436Z" fill="#319CFF"/>
          </svg>
        </div>
    <nav class="nav">
      <a class="nav__link" :class=" this.$route.name === 'main-page' ? 'active' : ''" @click="goTo('main')">Главная</a>
      <a class="nav__link" :class=" this.$route.name === 'lk-page' ? 'active' : ''" @click="goTo('lk')">Личный кабинет</a>
      <a class="nav__link" :class=" this.$route.name === 'sklad-page' ? 'active' : ''" @click="goTo('sklad')">Склад</a>
      <a class="nav__link" :class=" this.$route.name === 'schedule-page' ? 'active' : ''">Расписание</a>
      <a class="nav__link" :class=" this.$route.name === 'video-page' ? 'active' : ''" @click="goTo('video')">Видеопоток</a>
      <a class="nav__link" :class=" this.$route.name === 'phones-page' ? 'active' : ''" @click="goTo('phones')">О нас</a>
      <a class="nav__link" :class=" this.$route.name === 'lk-page' ? 'active' : ''" @click="goTo('lk')">{{ user.login }}</a>
      <a class="nav__link" @click="signout" style="margin-right: 50px" v-if="isAvailable">Выйти</a>
      <a class="nav__link" @click="goTo('auth')" style="margin-right: 50px" v-else>Войти</a>

    </nav>
      </div>
    </div>
  </header>
</template>

<script>
import logo from '@/components/temp_startup/logo'

export default {
  name: "upper",
  components: {
    logo,
  },
  data: function () {
    return {
      user: {
        login: '',
      },
      queries: {
        add: 'main/app/add',
        refresh: 'api/refresh/token',
        retrieve: 'main/app/dots/all',
      },

    }
  },
  mounted() {
    if (localStorage.getItem('login') !== null || localStorage.getItem('login') !== undefined) this.user.login = localStorage.getItem("login")
  },
  computed: {
    isAvailable: function () {
      return (localStorage.getItem('login') !== null) && (localStorage.getItem('login') !== undefined) && (localStorage.getItem('login') !== '');
    },
  },
  methods: {
    signout: function(event) {
      console.log('close current session...');
      localStorage.clear();
      this.$router.push({name: 'auth-page'});
      window.scrollTo(0,0);
    },
    goTo: function (path) {
    this.$router.push({name: path+'-page'});
    },
  },

  fetchToken: async function(repeat, ...args) {

    console.log('fetching tokens from server...');
    let response = await fetch(baseURL + this.queries.refresh, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      //body: JSON.stringify({ refreshToken : this.$session.get(this.refresh)}),
      body: JSON.stringify({ refreshToken : localStorage.getItem("refreshToken")}),
    }).catch(function (){
      alert("Error while getting token. Check your connection")
    });

    console.log('check if response is ok');
    if (response.ok) {

      console.log('successful fetching new token');
      console.log('getting json object...');
      let json = await response.json();
      if (json) {
        //this.$session.set(this.access, json.accessToken);
        localStorage.setItem("accessToken", json.accessToken);
        window.location.reload();
        repeat = repeat.bind(this);
        console.log('repeating losed operation...');
        repeat(args);
      } else console.error('empty response body');

    } else {
      console.error(`bad response ${response.status} ${response.statusText}`);

      console.log('redirecting to login-page...');

      this.signout();
    }
  },
}
</script>


<style>
@import "../../assets/css/style.css";

a{
  cursor: pointer;
}

svg {
  cursor: pointer;
}

h1,h2,h3 {
  margin: 0 0 0 50px;
}

.header__logo {
  margin: 0 0 0 40px;
}

</style>