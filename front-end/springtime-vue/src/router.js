import Vue from 'vue'
import VueRouter from 'vue-router'
import registration_container from "@/components/temp_views/registration_container";
import error_container from "@/components/temp_views/error_container";
import page_container from "@/components/temp_views/page_container";
import lk_container from "@/components/temp_views/lk_container";
import phones_container from "@/components/temp_views/phones_container";
import sklad_container from "@/components/temp_views/sklad_container"; // warehouse!!!
import video_container from "@/components/temp_views/video_container";

Vue.use(VueRouter);

export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'default-page',
            component: page_container,
            beforeEnter: (to, from, next) => {
                    next({name: 'main-page'});
            }
        },
        {
            path: '/auth',
            name: 'auth-page',
            component: registration_container,
            props: {
                typeOfPage: "auth",
            },
            beforeEnter: (to, from, next) => {
                // if (localStorage.getItem("accessToken") && localStorage.getItem("refreshToken")) {
                //     next({name: 'main-page'})
                // } else {
                    next()
                //}
            }

        },
        {
            path: '/registration',
            name: 'registration-page',
            component: registration_container,
            props: {
                typeOfPage: "reg",
            },
            beforeEnter: (to, from, next) => {
                // TODO: RETURN THIS PART
                // if (localStorage.getItem("accessToken") && localStorage.getItem("refreshToken")) {
                //     next({name: 'main-page'})
                // } else {
                //     next()
                // }
                next();
            }

        },
        {
            path: '/sklad',
            name: 'sklad-page',
            component: sklad_container,
            beforeEnter: (to, from, next) => {
                next();
                // TODO: RETURN AFTER ALL
            }
        },
        {
            path: '/confirm',
            name: 'confirm-page',
            component: registration_container,
            props: {
                typeOfPage: "confirm",
            },
            beforeEnter: (to, from, next) => {
                if (localStorage.getItem("accessToken") && localStorage.getItem("refreshToken")) {
                    next({name: 'main-page'})
                } else if (from.name === 'registration-page') {
                    next()
                } else next({name: 'auth-page'});
            }

        },
        {
            path: '/main',
            name: 'main-page',
            component: page_container,
            beforeEnter: (to, from, next) => {
                next();
            }
        },
        {
            path: '/video',
            name: 'video-page',
            component: video_container,
            beforeEnter: (to, from, next) => {
                next();
            }
        },
        {
            path: '/lk',
            name: 'lk-page',
            component: lk_container,
            beforeEnter: (to, from, next) => {
                next();
            }
        },
        {
            path: '/phones',
            name: 'phones-page',
            component: phones_container,
            beforeEnter: (to, from, next) => {
                next();
            }
        },
        {
            path: '/*',
            name: 'error-page',
            component: error_container,
            props: {
                default: true,
                errorCode: "404",
                errorMessage: "Данной страницы не сущуствует. Повторите авторизацию!"
            }
        },
        {
            path: '/error',
            name: 'error-page-app',
            component: error_container,
            props: {
                default: true,
                errorCode: "401",
                errorMessage: "У вас нет доступа к приложению. Сначала авторизуйтесь!"
            }
        }
    ]
});