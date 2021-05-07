<template>
 <div>
   <upper/>
   <info/>
   <sending/>
   <about/>
   <cons/>
   <stand/>
   <how/>
   <team/>
   <phrase/>
   <callback/>
   <downer/>
 </div>
</template>

<script>
import upper from '@/components/temp_main/upper'
import info from '@/components/temp_main/info'
import about from '@/components/temp_main/about'
import sending from '@/components/temp_main/sending'
import cons from "@/components/temp_main/cons";
import stand from "@/components/temp_main/stand";
import how from "@/components/temp_main/how";
import team from "@/components/temp_main/team";
import phrase from "@/components/temp_main/phrase";
import callback from "@/components/temp_main/callback";
import downer from "@/components/temp_main/downer";

export default {
  name: 'page',
  props: [],
  components: {
    upper,
    info,
    about,
    sending,
    cons,
    stand,
    how,
    team,
    phrase,
    callback,
    downer,

  },
}
</script>

<style>

</style>