package org.sparta.ci_test.domain;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimpleService {

	private final RedissonClient redissonClient;

	public void simpleFunc() {
		RLock lock = redissonClient.getLock("lock");


		try {
			boolean acquireLock = lock.tryLock(1L, 5L, TimeUnit.SECONDS);

			if (!acquireLock) {
				return;
			}

		} catch (InterruptedException e) {
			// controller advice 예외 처리 위임
			throw new RuntimeException(e);
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}

		return;

	}
}