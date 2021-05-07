<template>
  <div>
    <upper/>
    <broadcast/>
    <downer/>
  </div>
</template>

<script>

import upper from "@/components/temp_main/upper";
import downer from "@/components/temp_main/downer";
import broadcast from "@/components/temp_video/broadcast";

export default {
  name: "broadcaster",
  components: {
    broadcast,
    upper,
    downer,
  },
}
</script>

<style scoped>

</style>