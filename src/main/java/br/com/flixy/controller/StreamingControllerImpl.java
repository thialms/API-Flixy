package br.com.flixy.controller;

import br.com.flixy.controller.request.StreamingRequest;
import br.com.flixy.controller.response.StreamingResponse;
import br.com.flixy.entity.Streaming;
import br.com.flixy.mapper.StreamingMapper;
import br.com.flixy.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flixy/streaming")
@RequiredArgsConstructor
public class StreamingControllerImpl implements StreamingController {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        List<StreamingResponse> streamings = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request) {
        Streaming savedStreaming = streamingService.save(StreamingMapper.toStreaming(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
