<template>
  <div>
    <div class="mt-16">
      <img src="@/assets/images/closed.png" width="150" height="130" /><br />
      <div class="mt-5">
        <span style="font-size: 1.3rem">πμ€λ μμ λ!!π</span><br />
        <span>μ€λ νλ£¨λ μκ³ νμ¨μ΅λλ€!</span>
      </div>
    </div>
    <div class="mt-10">
      <span
        >"{{ storeName }}" λ§€μ₯μ μμμ <br />μ λ§λ‘ μ’λ£νμκ² μ΅λκΉ? </span
      ><br />
      <!--κΈμ μ¬μ΄μ¦ μ€μ΄κ³  λΉ¨κ°μμΌλ‘ νμν λΆλΆ!-->
      <div class="mt-7">
        <span id="red-small"
          >π₯μμμ μ’λ£νμλ©΄ μ€λ λ±λ‘νμ  λ§κ°ν μΈ μνμ΄ μ λΆ
          μ΄κΈ°νλ©λλ€π₯</span
        >
      </div>
    </div>
    <br />
    <br />

    <div class="d-flex justify-content-around">
      <button @click="noClose" id="button-no">μλμ€</button>
      <button @click="realClose" id="button-yes">μμμ’λ£</button>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "closeCheck",
  data() {
    return {
      storeId: Number,
      storeName: "",
    };
  },
  async created() {
    await http.get(`/store/${this.$route.params.storeId}`).then((response) => {
      this.storeName = response.data.storeName;
    });
    // await http
    //   .get(`sale/list/${this.$route.params.storeId}`)
    //   .then((response) => {
    //     console.log(response.data);
    //   });
  },
  methods: {
    realClose() {
      this.storeId = this.$route.params.storeId;
      http.put(`/store/close/${this.storeId}`).then((response) => {
        if (response.status == 204) {
          this.$alert("μ€λ λ±λ‘λ μ¬κ³ κ° μμ΄ μμ μ’λ£κ° λΆκ°λ₯ν©λλ€.");
        } else {
          this.$alert(
            "λ§€μ₯ κ²°μ°μ΄ μλ£λμ΄ λ°μ΄ν°κ° μ μ₯λκ³  μμ μ’λ£λμμ΅λλ€."
          );
          this.$router.push("/mypage/owner");
        }
      });
    },
    noClose() {
      this.$router.push("/mypage/owner");
    },
  },
};
</script>

<style scoped>
#red-small {
  color: rgb(222, 124, 39);
  font-size: 0.75rem;
}
#button-no {
  height: 40px;
  border: none;
  display: inline-block;
  border-radius: 5px;
  text-decoration: none;
  margin: 5 10;
  padding: 10 10;
  box-sizing: border-box;
  background-color: #66a32e;
  color: #ffffff;
  width: 100px;
}
#button-yes {
  height: 40px;
  border: none;
  display: inline-block;
  border-radius: 5px;
  text-decoration: none;
  margin: 5 10;
  padding: 10 10;
  box-sizing: border-box;
  background-color: #d97b38;
  color: #ffffff;
  width: 100px;
}
</style>
