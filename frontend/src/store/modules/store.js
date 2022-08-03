const store = {
    namespaced: true,
    state: {
      // 현재 주소
      currentAddress:"",
      // 위도 경도
      currentX:"",
      currentY:"",
      // 주문 상품 PK
      currentItemId:"",
      // 주문 가게 PK
      orderStore:"",

    },
    getters: {
      currentAddress: state => state.currentAddress,
      currentItemId: state => state.currentItemId,
      currentX: state => state.currentX,
      currentY: state => state.currentY,
      orderStore: state => state.orderStore,

    },
    actions: {
      getAddress :({commit}, address) => {
        commit("GET_ADDRESS", address)
        console.log("현재 주소 등록완료")
      },
      getCurrentX :({commit}, currentX) => {
        commit("GET_CURRENTX", currentX)
        console.log("현재 위도 등록완료")
      },
      getCurrentY :({commit}, currentY) => {
        commit("GET_CURRENTY", currentY)
        console.log("현재 경도 등록완료")
      },  
      getItemId : ({commit}, itemId) => {
        commit("GET_ITEMID", itemId)
        console.log("ItemId 등록 완료")
      },
      getOrderStore : ({commit}, storeId) => {
        commit("GET_ORDERSTORE", storeId)
        console.log("storeId 등록 완료")
      },
    },
    mutations: {
      GET_ADDRESS: (state, address) => {
        state.currentAddress = address;
      },
      GET_ITEMID: (state, itemId) => {
        state.currentItemId = itemId;
      },
      GET_CURRENTX: (state, storeId) => {
        state.orderStore = storeId;
      },
      GET_CURRENTY: (state, currentX) => {
        state.currentX = currentX;
      },
      GET_ORDERSTORE: (state, currentY) => {
        state.currentY = currentY;
      },
    },
  };
  
  export default store;