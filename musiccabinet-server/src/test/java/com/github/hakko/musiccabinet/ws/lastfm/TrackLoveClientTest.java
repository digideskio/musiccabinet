package com.github.hakko.musiccabinet.ws.lastfm;

import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Test;

import com.github.hakko.musiccabinet.domain.model.library.LastFmUser;
import com.github.hakko.musiccabinet.domain.model.music.Track;
import com.github.hakko.musiccabinet.exception.ApplicationException;

public class TrackLoveClientTest extends AbstractWSImplementationTest {

	@Test
	public void validateParameters() throws ApplicationException {

		final String method = TrackLoveClient.METHOD;
		final String lastFmUser = "arnathalon";
		final String sessionKey = "sessionkey";
		final String artist = "artist";
		final String track = "track";

		new TrackLoveClient() {
			@Override
			protected WSResponse executeWSRequest(List<NameValuePair> params) throws ApplicationException {

				assertHasParameter(params, PARAM_METHOD, method);
				assertHasParameter(params, PARAM_TRACK, track);
				assertHasParameter(params, PARAM_ARTIST, artist);
				assertHasParameter(params, PARAM_SK, sessionKey);

				return null;
			}

		}.love(new Track(artist, track), new LastFmUser(lastFmUser, sessionKey));

	}

}