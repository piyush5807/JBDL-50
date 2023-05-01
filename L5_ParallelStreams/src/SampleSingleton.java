public class SampleSingleton {

  private static SampleSingleton sampleSingleton = null;


  private SampleSingleton() {
  }

  public static SampleSingleton getInstance() {
    if(sampleSingleton == null){
      sampleSingleton = new SampleSingleton();
    }

    return sampleSingleton;
  }


}



















