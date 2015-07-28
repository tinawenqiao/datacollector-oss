/**
 * (c) 2015 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
package com.streamsets.datacollector.execution.snapshot.file.dagger;

import com.streamsets.datacollector.execution.snapshot.file.FileSnapshotStore;
import com.streamsets.datacollector.main.RuntimeInfo;
import com.streamsets.datacollector.main.RuntimeModule;
import com.streamsets.datacollector.util.LockCache;
import com.streamsets.datacollector.util.LockCacheModule;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provides a singleton instance of FileSnapshotStore
 */
@Module(injects = FileSnapshotStore.class, library = true, includes = {RuntimeModule.class,
  LockCacheModule.class})
public class FileSnapshotStoreModule {

  @Provides @Singleton
  public FileSnapshotStore provideSnapshotStore(RuntimeInfo runtimeInfo, LockCache<String> lockCache) {
    return new FileSnapshotStore(runtimeInfo, lockCache);
  }

}
