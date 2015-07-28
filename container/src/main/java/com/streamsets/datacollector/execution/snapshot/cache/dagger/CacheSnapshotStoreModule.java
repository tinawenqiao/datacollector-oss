/**
 * (c) 2015 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
package com.streamsets.datacollector.execution.snapshot.cache.dagger;

import com.streamsets.datacollector.execution.SnapshotStore;
import com.streamsets.datacollector.execution.snapshot.cache.CacheSnapshotStore;
import com.streamsets.datacollector.execution.snapshot.file.FileSnapshotStore;
import com.streamsets.datacollector.execution.snapshot.file.dagger.FileSnapshotStoreModule;
import com.streamsets.datacollector.util.LockCache;
import com.streamsets.datacollector.util.LockCacheModule;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provides a singleton instance of FileSnapshotStore
 */
@Module(injects = SnapshotStore.class, library = true, includes = {FileSnapshotStoreModule.class,
  LockCacheModule.class})
public class CacheSnapshotStoreModule {

  @Provides
  @Singleton
  public SnapshotStore provideSnapshotStore(FileSnapshotStore fileSnapshotStore,
     LockCache<String> lockCache) {
    return new CacheSnapshotStore(fileSnapshotStore, lockCache);
  }

}
