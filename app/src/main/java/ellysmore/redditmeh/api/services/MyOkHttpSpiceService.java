package ellysmore.redditmeh.api.services;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.okhttp.OkHttpSpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;

import android.app.Application;

public class MyOkHttpSpiceService extends OkHttpSpiceService {

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        return new CacheManager();
    }
}
