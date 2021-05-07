<template>
  <div>
    <basic :access="accessTokenName" :refresh="refreshTokenName" v-if="isAuthorized" />
  </div>
</template>

<script>

import basic from '@/components/basic'

export default {
  name: 'start',
  components: {
    basic,
  },
  data: function() {
    return {
      accessTokenName: 'accessToken',
      refreshTokenName: 'refreshToken',
    };
  },
  computed: {
    access: function() {
      //return this.$session.get(this.accessTokenName);
      return localStorage.getItem("accessToken");
    },
    refresh: function() {
      //return this.$session.get(this.refreshTokenName);
      return localStorage.getItem("refreshToken");
    },
    isAuthorized: function() {
      return !((this.access === undefined) || (this.access === null) || (this.access === ''));
    },
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Jost&display=swap');

*, *:before, *:after {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  font-family: "Jost", serif;
  font-weight: normal;
}

#wrap {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #efefef;
  margin: 0 auto;
  padding: 0;
}

@media only all and (min-width: 1256px) {
  #wrap {
    width: 1245px;
    font-size: 16px;
  }

}

@media only all and (min-width: 882px) and (max-width: 1255px) {
  #wrap {
    width: 643px;
    font-size: 12px;
  }
}

@media only all and (max-width: 881px) {
  #wrap {
    width: 320px;
    font-size: 8px;
  }
}
</style>