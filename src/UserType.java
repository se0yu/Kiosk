public enum UserType {
    //userType에 따라 할인율 적용
    PATRIOT(1){
        @Override
        public double discount(double sumPrice) {
            sumPrice*=0.9;
            return Math.round(sumPrice*100)/100.0;
        }
    }
    ,ARMY(2){
        @Override
        public double discount(double sumPrice) {
            sumPrice*=0.95;
            return Math.round(sumPrice*100)/100.0;
        }
    },STUDENT(3){
        @Override
        public double discount(double sumPrice) {
            sumPrice*=0.97;
            return Math.round(sumPrice*100)/100.0;
        }
    },COMMON(4){
        @Override
        public double discount(double sumPrice){
            return  sumPrice;
        }
    };

    private final int selectUserType;

    UserType(int selectUserType){
        this.selectUserType = selectUserType;
    }

    public abstract double discount(double sumPrice);

    public static UserType userType (int selectUserType){

        for(UserType userType : UserType.values()) {
            if (userType.selectUserType == selectUserType) {
                return userType;
            }
        }
        return COMMON;
    }

}

