package org.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000355_DesignTwitter {

	static class TweetNode {

		private final int userId;
		private final int tweetId;

		public TweetNode(int _userId, int _tweetId) {
			this.userId = _userId;
			this.tweetId = _tweetId;
		}

		public int getUserId() {
			return this.userId;
		}

		public int getTweetId() {
			return this.tweetId;
		}
	}

	static class Twitter {
		private final Map<Integer, Set<Integer>> userToFollowers;
		private final Stack<TweetNode> tweets;

		/** Initialize your data structure here. */
		public Twitter() {
			userToFollowers = new HashMap<>();
			tweets = new Stack<>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			final TweetNode tweet = new TweetNode(userId, tweetId);
			tweets.push(tweet);
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			final List<Integer> newsFeed = new LinkedList<>();
			int counter = 10;
			for (TweetNode tweet : tweets) {
				final int tweetUserId = tweet.getUserId();
				if (tweetUserId == userId || follows(userId, tweetUserId)) {
					newsFeed.add(tweet.getTweetId());
					counter--;
					if (counter == 0)
						break;
				}
			}
			return newsFeed;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (userToFollowers.containsKey(followerId)) {
				userToFollowers.get(followerId).add(followeeId);
			} else {
				final Set<Integer> followees = new HashSet<>();
				followees.add(followeeId);
				userToFollowers.put(followerId, followees);
			}
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (userToFollowers.containsKey(followerId)) {
				userToFollowers.get(followerId).remove(followeeId);
			}
		}
		
		private boolean follows(int followerId, int followeeId) {
			final Set<Integer> followees = userToFollowers.get(followerId);
			return followees != null && followees.contains(followeeId);
		}
	}

	static class Stack<V> implements Iterable<V> {
		private Node<V> head;

		private static class Node<V> {
			private V item;
			private Node<V> next;

			public Node(V item) {
				this.item = item;
			}
		}

		public void push(V item) {
			final Node<V> x = new Node<V>(item);
			x.next = head;
			head = x;
		}

		public V pop() {
			final V item = head.item;
			head = head.next;
			return item;
		}

		@Override
		public Iterator<V> iterator() {
			return new StackIterator();
		}

		private class StackIterator implements Iterator<V> {
			Node<V> cur = head;

			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public V next() {
				Node<V> x = cur;
				cur = cur.next;
				return x.item;
			}
		}
	}
}
