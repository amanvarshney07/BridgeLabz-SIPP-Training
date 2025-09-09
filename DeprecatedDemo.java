class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature - should not be used!");
    }
    
    public void newFeature() {
        System.out.println("This is the new improved feature - use this instead!");
    }
}

class DeprecatedDemo {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature();
        api.newFeature();
    }
}