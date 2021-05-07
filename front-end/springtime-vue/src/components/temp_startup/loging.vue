<template>
  <div id="loging">
    <div id="login-form">
      <fieldset>
        <label id="main_title">
          {{ typeOfPage === 'auth' ? 'ВХОД' : typeOfPage === 'reg' ? 'РЕГИСТРАЦИЯ' : 'ВВЕДИТЕ КОД ПОДТВЕРЖДЕНИЯ' }} </label>

        <input type="email" placeholder="ПОЧТА" title="почта" v-model="user.login" required="true"
               autocomplete="username" v-if="typeOfPage === 'reg' || typeOfPage === 'auth'">
        <br v-if="typeOfPage === 'reg' || typeOfPage === 'auth'"/>

        <input type="password" placeholder="ПАРОЛЬ" title="пароль" v-model="user.password" required="true"
               autocomplete="current-password" v-if="typeOfPage === 'reg' || typeOfPage === 'auth'">

        <input type="text" placeholder="ВАШ КОД" title="код" v-model="user.code" required="true" autocomplete="code"
               v-if="typeOfPage === 'confirm'">

        <br/>

        <a class="trouble_link" v-if="typeOfPage === 'auth'" @click="checkPassword"> ЗАБЫЛИ ПАРОЛЬ? </a>
        <br v-if="typeOfPage === 'auth'"/>
        <a @click="goTo('registration')" class="trouble_link" v-if="typeOfPage === 'auth'"> РЕГИСТРАЦИЯ </a>

        <a @click="goTo('auth')" class="trouble_link" v-if="typeOfPage === 'reg' || typeOfPage === 'confirm'"> ВЕРНУТЬСЯ КО ВХОДУ </a>

        <button @click="confirm" title="Получуть пароль" class="loging__btn" v-if="typeOfPage === 'reg'">
          <svg id="arrow" width="59" height="24" viewBox="0 0 59 24" fill="black" xmlns="http://www.w3.org/2000/svg">
            <path
                d="M58.0607 13.0607C58.6464 12.4749 58.6464 11.5251 58.0607 10.9393L48.5147 1.3934C47.9289 0.807611 46.9792 0.807611 46.3934 1.3934C45.8076 1.97919 45.8076 2.92893 46.3934 3.51472L54.8787 12L46.3934 20.4853C45.8076 21.0711 45.8076 22.0208 46.3934 22.6066C46.9792 23.1924 47.9289 23.1924 48.5147 22.6066L58.0607 13.0607ZM0 13.5H57V10.5H0V13.5Z"/>
          </svg>
        </button>

        <button @click="signin" title="Зайти в аккаунт" class="loging__btn" v-if="typeOfPage === 'auth'">
          <svg id="arrow" width="59" height="24" viewBox="0 0 59 24" fill="black" xmlns="http://www.w3.org/2000/svg">
            <path
                d="M58.0607 13.0607C58.6464 12.4749 58.6464 11.5251 58.0607 10.9393L48.5147 1.3934C47.9289 0.807611 46.9792 0.807611 46.3934 1.3934C45.8076 1.97919 45.8076 2.92893 46.3934 3.51472L54.8787 12L46.3934 20.4853C45.8076 21.0711 45.8076 22.0208 46.3934 22.6066C46.9792 23.1924 47.9289 23.1924 48.5147 22.6066L58.0607 13.0607ZM0 13.5H57V10.5H0V13.5Z"/>
          </svg>
        </button>

        <button @click="signup" title="Зарегестрироваться" class="loging__btn" v-if="typeOfPage === 'confirm'">
          <svg id="arrow" width="59" height="24" viewBox="0 0 59 24" fill="black" xmlns="http://www.w3.org/2000/svg">
            <path
                d="M58.0607 13.0607C58.6464 12.4749 58.6464 11.5251 58.0607 10.9393L48.5147 1.3934C47.9289 0.807611 46.9792 0.807611 46.3934 1.3934C45.8076 1.97919 45.8076 2.92893 46.3934 3.51472L54.8787 12L46.3934 20.4853C45.8076 21.0711 45.8076 22.0208 46.3934 22.6066C46.9792 23.1924 47.9289 23.1924 48.5147 22.6066L58.0607 13.0607ZM0 13.5H57V10.5H0V13.5Z"/>
          </svg>
        </button>

      </fieldset>
    </div>
  </div>
</template>

<script>
const baseURL = 'http://localhost:41143/';
export default {
  name: 'loging',
  props: ['access', 'refresh', 'typeOfPage'],
  data: function () {
    return {
      user: {
        login: '',
        password: '',
        code: ''
      },
      queries: {
        signin: 'api/aunt/sign_in',
        register: 'api/aunt/register',
        checkemail: 'api/aunt/confirm',
      },
    };
  },

  computed: {
    isNotFilled: function () {
      return !(this.user.login !== undefined && this.user.login !== null && this.user.password !== undefined && this.user.password !== null && this.user.login.length > 0 && this.user.password.length > 0);
    },
    isPasswordOkay: function () {
      let msg = '';
      if (this.user.password.length < 8) msg += 'Пароль должен быть не менее 8 символов\n'
      if (this.user.password.length > 20) msg += 'Пароль должен быть не более 20 символов\n'
      if (this.user.password.match(/[A-ZА-ЯЁ]/) === null || this.user.password.match(/[A-ZА-ЯЁ]/) === undefined || this.user.password.match(/[A-ZА-ЯЁ]/).length < 1) msg += 'Пароль должен содержать заглавные буквы/заглавную букву\n'
      if (this.user.password.match(/[0-9]/) === null || this.user.password.match(/[0-9]/) === undefined || this.user.password.match(/[0-9]/).length < 1) msg += 'Пароль должен содержать цифру/цифру\n'
      if (this.user.password.match(/[,.!?;:()]/) === null || this.user.password.match(/[,.!?;:()]/) === undefined || this.user.password.match(/[,.!?;:()]/).length < 1) msg += 'Пароль должен содержать знак/знаки препинания\n'
      if (msg === '') return true;
      else return msg;
    }
  },
  methods: {
    createMessage: async function (message) {
      console.error(message);
      alert(message);
    },
    goTo: function (path) {
      this.$router.push({name: path+'-page'});
    },
    checkPassword: function () {
      (this.user.password !== '') && (this.user.password !== null) && (this.user.password !== undefined) ? alert('Ваш пароль: '+ this.user.password) : alert('*вам на почту придет письмо со сменой пароля, но мы это еще не реализовали*')
    },


    signin: async function (event) {
      console.log('sign in account:');
      console.log(`user: ${this.user}`);

      console.log('fetching tokens from server...');
      let response = await fetch(baseURL + this.queries.signin, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8',
        },
        body: JSON.stringify(this.user)
      }).catch(function () {
        alert("Error while authentication. Check your connection")
      });

      let json = null;
      try {
        json = await response.json();
      } catch (e) {
        console.error(e);
        return;
      }

      console.log('check if response is ok (200)');
      if (response.ok) {
        console.log('response 200; get token');
        console.log(`response body: ${json}`);
        if (!json) {
          console.log('bad data: expected { accessToken, refreshToken }');
          this.createMessage(`*${json}`);
        } else {
          console.log(`got user access-token`);
          console.log(`got user refresh-token`);
          localStorage.setItem("accessToken", json.accessToken);
          localStorage.setItem("refreshToken", json.refreshToken);

          localStorage.setItem("login", this.user.login);


          this.$router.push({name: 'main-page'});
        }
      } else this.createMessage(`*${json.description}`);
    },

    signup: async function (event) {

      console.log('sign up new account:');

      console.log('fetching tokens from server...');
      let response = await fetch(baseURL + this.queries.register, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8',
        },
        body: JSON.stringify(this.user)
      }).catch(function () {
        alert("Error while getting token. Check your connection")
      });

      console.log('sent request');
      console.log('check if status 201');

      let json = null;
      try {
        json = await response.json();
      } catch (e) {
        console.error(e);
        return;
      }

      if (response.status === 201) {
        console.log('email created');
        console.log(`response body: ${JSON.stringify(json)}`);
        if (!json)
          console.log('bad data: expected { email }');
        else {
          console.log('got user access-token');
          console.log('get user refresh-token');

          localStorage.setItem("accessToken", json.accessToken);
          localStorage.setItem("refreshToken", json.refreshToken);
          localStorage.setItem("login", this.user.login);
          localStorage.removeItem("email");

          this.$router.push({name: 'main-page'});

        }
      } else {
        this.createMessage(`*${json.description}`);
      }
    },

    confirm: async function (event) {
      if (this.isNotFilled) alert('Поля не могут быть пустыми');
      else if (this.isPasswordOkay !== true) alert(this.isPasswordOkay);
      else {
        console.log('sign up new account:');
        console.log(`user: ${this.user}`);

        console.log('fetching tokens from server...');
        let response = await fetch(baseURL + this.queries.checkemail, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json;charset=utf-8',
          },
          body: JSON.stringify(this.user)
        }).catch(function () {
          alert("Error while getting token. Check your connection")
        });

        console.log('sent request');
        console.log('check if status 201');

        let json = null;
        try {
          json = await response.json();
        } catch (e) {
          console.error(e);
          return;
        }

        if (response.ok) {
          console.log('email created');
          console.log(`response body: ${JSON.stringify(json)}`);
          if (!json)
            console.log('bad data: expected { email }');
          else {
            if (json.email === true) {
              this.$router.push({name: 'confirm-page'});
            }
          }
        } else {
          this.createMessage(`*${json.description}`);
        }
      }
    },
  }
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap%27');

.trouble_link {
  float: left;
  text-decoration: underline;
  margin: 0 0 0 6%;
}

#main_title {
  vertical-align: middle;
  line-height: 65px;
  font-size: 170%;
}

#loging {
  background: #F6FBFF;
  display: block;
  width: 40%;
  margin: 0 auto;
}

#login-form {
  background: #F6FBFF;
}

#login-form input {
  outline: none;
  margin: auto;
  width: 90%;
  border: 1px solid #c6c9cc;
  border-radius: 15px;
  color: #555;
  display: block;
  padding: 1% 2%;
  height: 50px;
}

#login-form label {
  padding: 0 5%;
  color: #3e606f;
  font-family: Satisfy, Lato, Open Sans, Roboto, sans-serif;
  text-transform: capitalize;
  font-size: 170%
}

#login-form fieldset#back {
  text-align: left;
}

#login-form fieldset {
  padding: 4%;
  border: 1px solid #F6FBFF;
  border-radius: 5px;
  margin: 1% 1%;
  text-align: center;
}

#err_message {
  font-size: 100%;
  font-style: italic;
  margin-left: 10%;
  color: #cd1a21
}

.loging__btn {
  outline: 0 none !important;
  float: right;
  width: 95px;
  height: 46px;
  margin: 0 6% 0 0;
  background: #F3F3F3;
  border: 2px solid #6FB2E6;
  box-sizing: border-box;
  border-radius: 30px;
  transition: all 500ms ease;
}


.loging__btn:hover {
  outline: none;
  background: #6FB2E6;
  color: #fff;
  box-shadow: inset 0 0 0 3px #6FB2E6;
  cursor: pointer;
}

#arrow {
  height: 95%;
  width: 95%;

}

.loging__btn:hover svg {
  fill: white;
  transition: all 500ms ease;
}


@media only all and (min-width: 882px) and (max-width: 1255px) {
  #login-form {
    display: block;
    height: 100%;
    width: 100%;
  }

  #login-form label {
    font-size: 160%;
  }


  #loging {
    width: 50%;
  }
}

@media only all and (max-width: 881px) {
  #loging {
    display: block;
    width: 90%;
  }
}
</style>