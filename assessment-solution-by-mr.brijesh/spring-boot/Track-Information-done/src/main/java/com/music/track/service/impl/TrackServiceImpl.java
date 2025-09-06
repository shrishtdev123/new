package com.music.track.service.impl;

import com.music.track.dto.TrackRequest;
import com.music.track.model.Track;
import com.music.track.repository.TrackRepository;
import com.music.track.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;
    @Override
    public Track createTrack(TrackRequest trackRequest) {
        Track track=new Track();
        track.setAlbumName(trackRequest.albumName());
        track.setReleaseDate(trackRequest.releaseDate());
        track.setTitle(trackRequest.title());
        track.setPlayCount(trackRequest.playCount());
        return trackRepository.save(track);
    }
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void deleteTrack(Long trackId) {
        if (trackRepository.existsById(trackId)) {
            trackRepository.deleteById(trackId);
        }
    }

    @Override
    public List<Track> sortedTracks() {
        return trackRepository.findAll(Sort.by("id"));
    }
}
