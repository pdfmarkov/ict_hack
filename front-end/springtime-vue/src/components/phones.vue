<template>
  <div>
    <upper/>
    <partners/>
    <downer/>
  </div>
</template>

<script>
import partners from "@/components/temp_phones/partners";
import upper from "@/components/temp_main/upper";
import downer from "@/components/temp_main/downer";

export default {
name: "phones",
  components:{
  partners,
    upper,
    downer,
  },
}
</script>

<style scoped>

</style>